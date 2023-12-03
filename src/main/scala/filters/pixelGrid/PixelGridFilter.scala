package filters.pixelGrid

import filters.Filter
import models.pixels.Pixel

trait PixelGridFilter[T <: Pixel] extends Filter[Seq[Seq[T]]] {}
