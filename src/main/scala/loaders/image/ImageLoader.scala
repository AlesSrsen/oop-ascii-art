package loaders.image

import asciiApp.models.image.Image
import loaders.Loader

trait ImageLoader[T <: Image[_]] extends Loader[T] {}
