package asciiApp.console.argument.loaderArgument

import asciiApp.console.exceptions.MissingArgumentOptionException
import converters.image.rgb.BufferedImageToRGBImageConverter
import loaders.image.RGBImageLoader
import loaders.image.file.RGBImageFileLoader

import java.io.File

class FileRGBImageLoaderArgument extends RGBImageLoaderArgument {
  override def specification(): Seq[String] =
    super.specification().appended("<path>")

  override def aliases: Seq[String] = Seq("-i")

  override protected def argOptionsReducer(
    argumentOptions: Seq[String]): (RGBImageLoader, Args) = {
    if (argumentOptions.length < 1)
      throw new MissingArgumentOptionException(
        "No path to input image supplied to: " + argumentName)
    (
      new RGBImageFileLoader(
        new File(argumentOptions.head),
        new BufferedImageToRGBImageConverter),
      argumentOptions.drop(1))
  }

  override def argumentName: String = "--image"
}
