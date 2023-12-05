package filters.image.gray

import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter
import filters.image.generic.InvertImageFilter
import operators.GrayscalePixelOperator

/**
 * InvertGrayscaleImageFilter inverts the pixels of a Grayscale Image.
 */
class InvertGrayscaleImageFilter extends ImageFilter[Image[GrayscalePixel]] {
  override def applyFilter(item: Image[GrayscalePixel]): Image[GrayscalePixel] =
    new InvertImageFilter(new GrayscalePixelOperator)
      .applyFilter(item)
}
