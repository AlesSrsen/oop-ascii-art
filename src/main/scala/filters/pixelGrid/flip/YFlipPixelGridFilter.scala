package filters.pixelGrid.flip

import asciiApp.models.grid.PixelGrid
import asciiApp.models.pixels.Pixel
import filters.pixelGrid.PixelGridFilter

class YFlipPixelGridFilter[O <: Pixel] extends PixelGridFilter[O] {
  override def applyFilter(item: PixelGrid[O]): PixelGrid[O] =
    item.mapRowsGrid(row => row.reverse)
}
