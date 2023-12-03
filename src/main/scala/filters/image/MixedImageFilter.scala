package filters.image

import models.image.Image

class MixedImageFilter[T <: Image[_]](filters: Seq[ImageFilter[T]])
    extends ImageFilter[T] {
  override def applyFilter(item: T): T =
    filters.foldLeft(item)((acc, filter) => filter.applyFilter(acc))
}
