package filters.image.gray

import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter
import filters.image.generic.InvertImageFilter
import operators.GrayscalePixelOperator

/**
 * InvertGrayscaleImageFilter inverts the pixels of a Grayscale Image.
 */
class InvertGrayscaleImageFilter
    extends InvertImageFilter[GrayscalePixel](new GrayscalePixelOperator)
    with ImageFilter[Image[GrayscalePixel]] {}
