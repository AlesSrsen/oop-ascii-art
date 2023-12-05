package filters.image.generic.flip

import filters.image.ImageFilter
import filters.pixelGrid.flip.YFlipPixelGridFilter
import models.image.Image
import models.pixels.Pixel

class YFlipImageFilter[T <: Pixel] extends ImageFilter[Image[T]] {
  override def applyFilter(item: Image[T]): Image[T] =
    new Image(new YFlipPixelGridFilter().applyFilter(item.pixels))
}
