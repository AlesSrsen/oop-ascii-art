package filters.image.generic

import asciiApp.models.image.Image
import asciiApp.models.pixels.Pixel
import filters.image.ImageFilter
import filters.pixelGrid.BrightnessPixelGridFilter
import operators.PixelOperator

class BrightnessImageFilter[T <: Pixel](
  amount: Int,
  pixelOperator: PixelOperator[T])
    extends ImageFilter[Image[T]] {
  override def applyFilter(item: Image[T]): Image[T] =
    new Image(
      new BrightnessPixelGridFilter(amount, pixelOperator)
        .applyFilter(item.pixels))
}
