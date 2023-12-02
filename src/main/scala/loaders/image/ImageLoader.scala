package loaders.image

import loaders.Loader
import models.image.Image

trait ImageLoader[T <: Image[_]] extends Loader[T] {}
