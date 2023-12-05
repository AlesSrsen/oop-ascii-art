package filters.pixelGrid

import models.grid.PixelGrid
import models.pixels.Pixel
import operators.PixelOperator

class InvertPixelGridFilter[O <: Pixel](pixelOperator: PixelOperator[O])
    extends PixelGridFilter[O] {

  override def applyFilter(item: PixelGrid[O]): PixelGrid[O] =
    item.mapPixelsGrid(pixel =>
      pixelOperator.subtract(pixelOperator.max(), pixel))

}
