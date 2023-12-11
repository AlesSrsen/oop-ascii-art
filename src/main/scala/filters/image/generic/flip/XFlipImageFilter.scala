package filters.image.generic.flip

import asciiApp.models.image.Image
import asciiApp.models.pixels.Pixel
import filters.image.ImageFilter

class XFlipImageFilter[T <: Pixel] extends ImageFilter[Image[T]] {
  override def applyFilter(item: Image[T]): Image[T] =
    new Image(item.pixels.reversedGrid())
}
