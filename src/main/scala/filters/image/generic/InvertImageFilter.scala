package filters.image.generic

import asciiApp.models.image.Image
import asciiApp.models.pixels.Pixel
import filters.image.ImageFilter
import filters.pixelGrid.InvertPixelGridFilter
import operators.PixelOperator

/**
 * InvertImageFilter inverts the pixels of an Image.
 * @param pixelOperator the PixelOperator to be used.
 */
class InvertImageFilter[T <: Pixel](pixelOperator: PixelOperator[T])
    extends ImageFilter[Image[T]] {
  override def applyFilter(item: Image[T]): Image[T] =
    new Image(
      new InvertPixelGridFilter(pixelOperator)
        .applyFilter(item.pixels))
}
