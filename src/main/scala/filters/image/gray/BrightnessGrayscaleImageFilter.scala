package filters.image.gray

import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter
import filters.image.generic.BrightnessImageFilter
import operators.GrayscalePixelOperator

class BrightnessGrayscaleImageFilter(amount: Int)
    extends ImageFilter[Image[GrayscalePixel]] {
  require(amount >= -255 && amount <= 255)
  override def applyFilter(item: Image[GrayscalePixel]): Image[GrayscalePixel] =
    new BrightnessImageFilter(amount, new GrayscalePixelOperator)
      .applyFilter(item)
}
