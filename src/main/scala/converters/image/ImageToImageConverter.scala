package converters.image

import asciiApp.models.image.Image
import converters.Converter

/**
 * Converts an image of type I to an image of type O.
 *
 * @tparam I type of input image
 * @tparam O type of output image
 */
trait ImageToImageConverter[I <: Image[_], O <: Image[_]]
    extends Converter[I, O] {}
