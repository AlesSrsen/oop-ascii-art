package console.argument.loaderArgument

import converters.image.rgb.BufferedImageToRGBImageConverter
import loaders.image.RGBImageLoader
import loaders.image.file.RGBImageFileLoader

import java.io.File

class FileLoaderArgument extends LoaderArgument {
  override def parseTopAndPop(args: Args): (Boolean, Args) =
    if (args.nonEmpty && args.head == argumentName) {
      if (args.length < 2)
        throw new IllegalArgumentException("No path to image")
      if (!new File(args(1)).isFile)
        throw new IllegalArgumentException("No such file")
      (true, args.drop(2))
    } else
      (false, args)

  override def specification(): Seq[String] = Seq(argumentName, "path to image")

  override def getRGBImageLoader(args: Args): (Option[RGBImageLoader], Args) = {
    val (isParsed, _) = parseTopAndPop(args)
    if (isParsed)
      (
        Some(
          new RGBImageFileLoader(
            new File(args(1)),
            new BufferedImageToRGBImageConverter)),
        args.drop(2))
    else
      (None, args)
  }

  override def argumentName: String = "--image"
}
