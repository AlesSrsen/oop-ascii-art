package filters.image.gray

import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter
import filters.image.generic.BrightnessImageFilter
import operators.GrayscalePixelOperator

/**
 * BrightnessGrayscaleImageFilter changes the brightness of a Grayscale Image.
 * @param amount the amount of brightness to be added. Must be between -255 and 255.
 */
class BrightnessGrayscaleImageFilter(amount: Int)
    extends ImageFilter[Image[GrayscalePixel]] {
  require(amount >= -255 && amount <= 255)
  override def applyFilter(item: Image[GrayscalePixel]): Image[GrayscalePixel] =
    new BrightnessImageFilter(amount, new GrayscalePixelOperator)
      .applyFilter(item)
}
