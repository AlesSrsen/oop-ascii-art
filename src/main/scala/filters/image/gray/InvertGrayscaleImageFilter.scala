package filters.image.gray

import filters.image.ImageFilter
import filters.image.generic.InvertImageFilter
import models.image.Image
import models.pixels.GrayscalePixel
import operators.GrayscalePixelOperator

class InvertGrayscaleImageFilter extends ImageFilter[Image[GrayscalePixel]] {
  override def applyFilter(item: Image[GrayscalePixel]): Image[GrayscalePixel] =
    new InvertImageFilter(new GrayscalePixelOperator)
      .applyFilter(item)
}
