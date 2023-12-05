package filters.image.gray

import filters.image.ImageFilter
import filters.pixelGrid.InvertPixelGridFilter
import models.image.GrayscaleImage
import operators.GrayscalePixelOperator

class InvertGrayscaleImageFilter extends ImageFilter[GrayscaleImage] {
  override def applyFilter(item: GrayscaleImage): GrayscaleImage =
    new GrayscaleImage(
      new InvertPixelGridFilter(new GrayscalePixelOperator)
        .applyFilter(item.pixels))
}
