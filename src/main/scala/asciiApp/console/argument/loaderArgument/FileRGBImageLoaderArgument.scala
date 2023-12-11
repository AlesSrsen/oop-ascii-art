package asciiApp.console.argument.loaderArgument

import asciiApp.console.exceptions.{InvalidArgumentOptionException, MissingArgumentOptionException}
import loaders.image.RGBImageLoader
import loaders.image.file.{GifRGBImageFileLoader, JpgRGBImageFileLoader, PngRGBImageFileLoader}

import java.io.File
import java.nio.file.Paths

class FileRGBImageLoaderArgument extends RGBImageLoaderArgument {
  override def specification(): Seq[String] =
    super.specification().appended("<path>")

  override def aliases: Seq[String] = Seq("-i")

  override protected def argOptionsReducer(
    argumentOptions: Seq[String]): (RGBImageLoader, Args) = {
    if (argumentOptions.length < 1)
      throw new MissingArgumentOptionException(
        "No path to input image supplied to: " + argumentName)
    val imageFile = new File(argumentOptions.head)
    val extension = Paths
      .get(imageFile.getAbsolutePath)
      .getFileName
      .toString
      .split("\\.")
      .last
    (extension match {
      case "png" => new PngRGBImageFileLoader(imageFile)
      case "gif" => new GifRGBImageFileLoader(imageFile)
      case "jpg" => new JpgRGBImageFileLoader(imageFile)
      case _ =>
        throw new InvalidArgumentOptionException(
          "Wrong file extension: " + Paths
            .get(imageFile.getAbsolutePath)
            .getFileName
            .toString
            .split("\\.")
            .last)
    }, argumentOptions.drop(1))
  }

  override def argumentName: String = "--image"
}
