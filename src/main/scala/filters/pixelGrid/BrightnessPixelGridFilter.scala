package filters.pixelGrid

import asciiApp.models.grid.PixelGrid
import asciiApp.models.pixels.Pixel
import operators.PixelOperator

/**
 * BrightnessPixelGridFilter changes the brightness of the pixels in the given PixelGrid.
 * @param amount the amount to be added to the pixels. Can be also negative.
 * @param pixelOperator the pixel operator to be used.
 * @tparam O the type of the pixel.
 */
class BrightnessPixelGridFilter[O <: Pixel](
  amount: Int,
  pixelOperator: PixelOperator[O])
    extends PixelGridFilter[O] {

  override def applyFilter(item: PixelGrid[O]): PixelGrid[O] =
    item.mapPixelsGrid(pixel => pixelOperator.addScalar(pixel, amount))

}
