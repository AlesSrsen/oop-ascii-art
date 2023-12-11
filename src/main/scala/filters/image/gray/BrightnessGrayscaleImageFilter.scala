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
    extends BrightnessImageFilter[GrayscalePixel](
      amount,
      new GrayscalePixelOperator)
    with ImageFilter[Image[GrayscalePixel]] {
  require(amount >= -255 && amount <= 255)
}
