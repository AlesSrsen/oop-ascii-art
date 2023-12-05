package console.argument.loaderArgument

import converters.image.rgb.BufferedImageToRGBImageConverter
import loaders.image.RGBImageLoader
import loaders.image.file.RGBImageFileLoader

import java.io.File

class FileRGBImageLoaderArgument extends RGBImageLoaderArgument {
  override def specification(): Seq[String] = Seq(argumentName, "path to image")

  override def getRGBImageLoader(args: Args): (Option[RGBImageLoader], Args) =
    getResult(
      args,
      (otherArgs: Args) => {
        if (otherArgs.length < 1)
          throw new IllegalArgumentException(
            "No path to input image supplied to: " + argumentName)
        (
          Some(
            new RGBImageFileLoader(
              new File(otherArgs.head),
              new BufferedImageToRGBImageConverter)),
          otherArgs.drop(1))
      }
    )

  override def argumentName: String = "--image"
}
