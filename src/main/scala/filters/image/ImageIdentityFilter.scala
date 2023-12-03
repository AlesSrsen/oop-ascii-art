package filters.image

import filters.IdentityFilter
import models.image.Image

class ImageIdentityFilter[T <: Image[_]]
    extends IdentityFilter[T]
    with ImageFilter[T] {}
