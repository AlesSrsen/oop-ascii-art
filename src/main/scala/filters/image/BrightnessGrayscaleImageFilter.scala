package filters.image

import models.image.GrayscaleImage
import models.pixels.GrayscalePixel

class BrightnessGrayscaleImageFilter(amount: Int)
    extends ImageFilter[GrayscaleImage] {
  override def applyFilter(item: GrayscaleImage): GrayscaleImage = {
    val newPixels =
      item.pixels.map(p =>
        p.map(pixel => new GrayscalePixel(pixel.gray + amount)))
    new GrayscaleImage(newPixels)
  }
}
