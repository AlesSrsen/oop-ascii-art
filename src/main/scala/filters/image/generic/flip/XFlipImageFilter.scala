package filters.image.generic.flip

import filters.image.ImageFilter
import filters.pixelGrid.flip.XFlipPixelGridFilter
import models.image.Image
import models.pixels.Pixel

class XFlipImageFilter[T <: Pixel] extends ImageFilter[Image[T]] {
  override def applyFilter(item: Image[T]): Image[T] =
    new Image(new XFlipPixelGridFilter().applyFilter(item.pixels))
}
