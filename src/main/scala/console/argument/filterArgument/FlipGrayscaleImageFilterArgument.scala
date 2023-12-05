package console.argument.filterArgument

import filters.image.ImageFilter
import filters.image.generic.flip.{XFlipImageFilter, YFlipImageFilter}
import models.image.Image
import models.pixels.GrayscalePixel

class FlipGrayscaleImageFilterArgument extends GrayscaleImageFilterArgument {
  override def specification(): Seq[String] =
    super.specification().appended("<x/y>")

  override def argumentName: String = "--flip"

  override protected def argOptionsReducer(argumentOptions: Seq[String])
    : (ImageFilter[Image[GrayscalePixel]], Args) = {
    if (argumentOptions.length < 1)
      throw new IllegalArgumentException("No flip direction specified")
    if (argumentOptions.head != "x" && argumentOptions.head != "y")
      throw new IllegalArgumentException("Invalid flip direction")
    if (argumentOptions.head == "x")
      (new XFlipImageFilter(), argumentOptions.drop(1))
    else
      (new YFlipImageFilter(), argumentOptions.drop(1))
  }
}
