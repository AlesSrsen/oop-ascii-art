package converters.image

import asciiApp.models.image.Image
import converters.Converter

trait ImageToImageConverter[I <: Image[_], O <: Image[_]]
    extends Converter[I, O] {}
