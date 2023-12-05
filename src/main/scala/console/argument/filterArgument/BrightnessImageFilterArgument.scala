package console.argument.filterArgument

import filters.image.ImageFilter
import filters.image.gray.BrightnessGrayscaleImageFilter
import models.image.Image
import models.pixels.GrayscalePixel

class BrightnessImageFilterArgument extends GrayscaleImageFilterArgument {
  override def specification(): Seq[String] =
    Seq(argumentName, "-255/+255")

  override def argumentName: String = "--brightness"

  override def getGrayscaleImageFilter(
    args: Args): (Option[ImageFilter[Image[GrayscalePixel]]], Args) =
    getResult(
      args,
      parseArgOptions
    )

  private def parseArgOptions = (otherArgs: Args) => {
    if (otherArgs.length < 1)
      throw new IllegalArgumentException("No brightness amount specified")
    otherArgs.head.toIntOption match {
      case Some(amount) =>
        (
          Some(new BrightnessGrayscaleImageFilter(amount)),
          otherArgs.drop(1)
        )
      case None =>
        throw new IllegalArgumentException("Brightness amount is not a number")
    }
  }
}
