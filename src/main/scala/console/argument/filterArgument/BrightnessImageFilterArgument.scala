package console.argument.filterArgument

import filters.image.ImageFilter
import filters.image.gray.BrightnessGrayscaleImageFilter
import models.image.Image
import models.pixels.GrayscalePixel

class BrightnessImageFilterArgument extends GrayscaleImageFilterArgument {
  override def specification(): Seq[String] = super.specification().appended("<-255/+255>")

  override def argumentName: String = "--brightness"
  override protected def argOptionsReducer(argumentOptions: Seq[String])
    : (ImageFilter[Image[GrayscalePixel]], Args) = {
    if (argumentOptions.length < 1)
      throw new IllegalArgumentException("No brightness amount specified")
    argumentOptions.head.toIntOption match {
      case Some(amount) =>
        (
          new BrightnessGrayscaleImageFilter(amount),
          argumentOptions.drop(1)
        )
      case None =>
        throw new IllegalArgumentException("Brightness amount is not a number")
    }
  }
}
