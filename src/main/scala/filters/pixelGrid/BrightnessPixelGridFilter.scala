package filters.pixelGrid

import asciiApp.models.grid.PixelGrid
import asciiApp.models.pixels.Pixel
import operators.PixelOperator

class BrightnessPixelGridFilter[O <: Pixel](
  amount: Int,
  pixelOperator: PixelOperator[O])
    extends PixelGridFilter[O] {

  override def applyFilter(item: PixelGrid[O]): PixelGrid[O] =
    item.mapPixelsGrid(pixel => pixelOperator.addScalar(pixel, amount))

}
