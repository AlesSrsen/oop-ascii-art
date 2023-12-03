package filters.pixelGrid

import models.pixels.Pixel
import operators.PixelOperator

class BrightnessPixelGridFilter[T <: Pixel](
  amount: Int,
  pixelOperator: PixelOperator[T])
    extends PixelGridFilter[T] {
  require(amount >= -255 && amount <= 255)

  override def applyFilter(item: Seq[Seq[T]]): Seq[Seq[T]] =
    item.map(row => row.map(pixel => pixelOperator.addScalar(pixel, 1)))

}
