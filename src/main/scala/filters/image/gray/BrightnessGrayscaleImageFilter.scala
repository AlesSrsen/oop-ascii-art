package filters.image.gray

import filters.image.ImageFilter
import filters.pixelGrid.BrightnessPixelGridFilter
import models.image.GrayscaleImage
import operators.GrayscalePixelOperator

class BrightnessGrayscaleImageFilter(amount: Int)
    extends ImageFilter[GrayscaleImage] {
  require(amount >= -255 && amount <= 255)
  override def applyFilter(item: GrayscaleImage): GrayscaleImage =
    new GrayscaleImage(
      new BrightnessPixelGridFilter(amount, new GrayscalePixelOperator)
        .applyFilter(item.pixels))
}
