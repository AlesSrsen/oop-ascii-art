package filters.pixelGrid.flip

import filters.pixelGrid.PixelGridFilter
import models.grid.PixelGrid
import models.pixels.Pixel

class XFlipPixelGridFilter[O <: Pixel] extends PixelGridFilter[O] {
  override def applyFilter(item: PixelGrid[O]): PixelGrid[O] =
    item.reversedGrid()
}
