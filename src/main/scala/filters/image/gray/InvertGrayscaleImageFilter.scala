package filters.image.gray

import filters.image.ImageFilter
import models.image.GrayscaleImage
import models.pixels.GrayscalePixel

class InvertGrayscaleImageFilter extends ImageFilter[GrayscaleImage] {
  override def applyFilter(item: GrayscaleImage): GrayscaleImage = {
    val newPixels = item.mapPixels(pixel =>
      new GrayscalePixel(GrayscalePixel.max().gray - pixel.gray))
    new GrayscaleImage(newPixels)
  }
}
