package filters.image

import asciiApp.models.image.Image
import filters.Filter

trait ImageFilter[T <: Image[_]] extends Filter[T] {}
