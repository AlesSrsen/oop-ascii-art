package filters.pixelGrid

import filters.Filter
import models.grid.PixelGrid
import models.pixels.Pixel

trait PixelGridFilter[O <: Pixel] extends Filter[PixelGrid[O]] {}
