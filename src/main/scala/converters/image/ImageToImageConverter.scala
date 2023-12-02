package converters.image

import converters.Converter
import models.image.Image

trait ImageToImageConverter[I <: Image[_], O <: Image[_]]
    extends Converter[I, O] {}
