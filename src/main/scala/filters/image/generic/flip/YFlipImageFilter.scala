package filters.image.generic.flip

import asciiApp.models.image.Image
import asciiApp.models.pixels.Pixel
import filters.image.ImageFilter
import filters.pixelGrid.flip.YFlipPixelGridFilter

class YFlipImageFilter[T <: Pixel] extends ImageFilter[Image[T]] {
  override def applyFilter(item: Image[T]): Image[T] =
    new Image(new YFlipPixelGridFilter().applyFilter(item.pixels))
}
