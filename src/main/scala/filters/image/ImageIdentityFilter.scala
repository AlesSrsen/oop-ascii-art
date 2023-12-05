package filters.image

import asciiApp.models.image.Image
import filters.IdentityFilter

class ImageIdentityFilter[T <: Image[_]]
    extends IdentityFilter[T]
    with ImageFilter[T] {}
