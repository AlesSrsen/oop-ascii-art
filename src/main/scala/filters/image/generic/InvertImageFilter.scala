package filters.image.generic

import filters.image.ImageFilter
import filters.pixelGrid.InvertPixelGridFilter
import models.image.Image
import models.pixels.Pixel
import operators.PixelOperator

class InvertImageFilter[T <: Pixel](pixelOperator: PixelOperator[T])
    extends ImageFilter[Image[T]] {
  override def applyFilter(item: Image[T]): Image[T] =
    new Image(
      new InvertPixelGridFilter(pixelOperator)
        .applyFilter(item.pixels))
}
