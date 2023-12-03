package filters.image

import models.image.GrayscaleImage
import models.pixels.GrayscalePixel

class BrightnessGrayscaleImageFilter(amount: Int)
    extends ImageFilter[GrayscaleImage] {
  require(amount >= -255 && amount <= 255)
  override def applyFilter(item: GrayscaleImage): GrayscaleImage = {
    val newPixels =
      item.mapPixels(pixel => new GrayscalePixel(pixel.gray + amount))
    new GrayscaleImage(newPixels)
  }
}
