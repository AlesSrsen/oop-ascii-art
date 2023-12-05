package console.argument.filterArgument

import console.argument.ArgumentWithoutOptions
import filters.image.ImageFilter
import filters.image.gray.InvertGrayscaleImageFilter
import models.image.Image
import models.pixels.GrayscalePixel

class InvertGrayscaleImageFilterArgument
    extends GrayscaleImageFilterArgument
    with ArgumentWithoutOptions[ImageFilter[Image[GrayscalePixel]]] {
  override def argumentName: String = "--invert"

  override protected def createInstance: ImageFilter[Image[GrayscalePixel]] =
    new InvertGrayscaleImageFilter
}
