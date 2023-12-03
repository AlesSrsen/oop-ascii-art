package filters.image.gray.flip

import filters.image.ImageFilter
import models.image.GrayscaleImage

class XFlipGrayscaleImageFilter extends ImageFilter[GrayscaleImage] {
  override def applyFilter(item: GrayscaleImage): GrayscaleImage = {
    val newPixels = item.pixels.reverse
    return new GrayscaleImage(newPixels)
  }
}
