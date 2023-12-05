package filters.pixelGrid

import asciiApp.models.grid.PixelGrid
import asciiApp.models.pixels.Pixel
import filters.Filter

trait PixelGridFilter[O <: Pixel] extends Filter[PixelGrid[O]] {}
