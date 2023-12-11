package asciiApp.console.argument.filterArgument

import asciiApp.console.exceptions.{InvalidArgumentOptionException, MissingArgumentOptionException}
import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter
import filters.image.gray.BrightnessGrayscaleImageFilter

class BrightnessGrayscaleImageFilterArgument extends GrayscaleImageFilterArgument {
  override def specification(): Seq[String] =
    super.specification().appended("<-255/+255>")

  override def argumentName: String = "--brightness"
  override protected def argOptionsReducer(argumentOptions: Seq[String])
    : (ImageFilter[Image[GrayscalePixel]], Args) = {
    if (argumentOptions.length < 1)
      throw new MissingArgumentOptionException("No brightness amount specified")
    argumentOptions.head.toIntOption match {
      case Some(amount) =>
        (
          new BrightnessGrayscaleImageFilter(amount),
          argumentOptions.drop(1)
        )
      case None =>
        throw new InvalidArgumentOptionException(
          "Invalid brightness amount: " + argumentOptions.head,
          new NumberFormatException())
    }
  }
}
