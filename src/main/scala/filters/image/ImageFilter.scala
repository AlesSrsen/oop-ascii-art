package filters.image

import filters.Filter
import models.image.Image

trait ImageFilter[T <: Image[_]] extends Filter[T] {}
