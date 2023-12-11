package filters.image.generic

import asciiApp.models.image.Image
import asciiApp.models.pixels.Pixel
import filters.image.ImageFilter
import operators.PixelOperator

/**
 * BrightnessImageFilter changes the brightness of an Image.
 * @param amount the amount of brightness to be added. Range depends on the type of Pixel.
 * @param pixelOperator the PixelOperator to be used.
 * @tparam T the type of Pixel.
 */
class BrightnessImageFilter[T <: Pixel](
  amount: Int,
  pixelOperator: PixelOperator[T])
    extends ImageFilter[Image[T]] {
  override def applyFilter(item: Image[T]): Image[T] =
    new Image(item.pixels.mapPixelsGrid(pixel =>
      pixelOperator.addScalar(pixel, amount)))
}
