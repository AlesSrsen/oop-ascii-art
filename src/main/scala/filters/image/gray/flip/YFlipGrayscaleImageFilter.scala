package filters.image.gray.flip

import filters.image.ImageFilter
import models.image.GrayscaleImage

class YFlipGrayscaleImageFilter extends ImageFilter[GrayscaleImage] {
  override def applyFilter(item: GrayscaleImage): GrayscaleImage = {
    val newPixels = item.mapRows(row => row.reverse)
    new GrayscaleImage(newPixels)
  }
}
