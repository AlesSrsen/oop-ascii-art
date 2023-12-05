package filters.pixelGrid

import asciiApp.models.grid.PixelGrid
import asciiApp.models.pixels.Pixel
import operators.PixelOperator

/**
 * InvertPixelGridFilter inverts the pixels in the given PixelGrid.
 * @param pixelOperator the pixel operator to be used.
 * @tparam O the type of the pixel.
 */
class InvertPixelGridFilter[O <: Pixel](pixelOperator: PixelOperator[O])
    extends PixelGridFilter[O] {
  override def applyFilter(item: PixelGrid[O]): PixelGrid[O] =
    item.mapPixelsGrid(pixel =>
      pixelOperator.subtract(pixelOperator.max(), pixel))

}
