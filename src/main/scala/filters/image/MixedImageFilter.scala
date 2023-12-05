package filters.image

import asciiApp.models.image.Image

/**
 * MixedImageFilter applies multiple ImageFilters to an Image.
 * @param filters the filters to be applied.
 * @tparam T the type of the image.
 */
class MixedImageFilter[T <: Image[_]](filters: Seq[ImageFilter[T]])
    extends ImageFilter[T] {
  override def applyFilter(item: T): T =
    filters.foldLeft(item)((acc, filter) => filter.applyFilter(acc))
}
