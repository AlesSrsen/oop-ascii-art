package console.argument.loaderArgument

import converters.image.rgb.BufferedImageToRGBImageConverter
import loaders.image.RGBImageLoader
import loaders.image.file.RGBImageFileLoader

import java.io.File

class FileLoaderArgument extends LoaderArgument {
  override def parseTopAndPop(args: Args): (Boolean, Args) =
    parseTopAndPop(
      args,
      (otherArgs: Args) => {
        if (otherArgs.length < 1)
          throw new IllegalArgumentException("No path to image")
        if (!new File(otherArgs.head).isFile)
          throw new IllegalArgumentException("No such file")
        (true, otherArgs.drop(1))
      }
    )

  override def specification(): Seq[String] = Seq(argumentName, "path to image")

  override def getRGBImageLoader(args: Args): (Option[RGBImageLoader], Args) =
    getResult(
      args,
      (otherArgs: Args) =>
        (
          Some(
            new RGBImageFileLoader(
              new File(otherArgs.head),
              new BufferedImageToRGBImageConverter)),
          otherArgs.drop(1)))

  override def argumentName: String = "--image"
}
