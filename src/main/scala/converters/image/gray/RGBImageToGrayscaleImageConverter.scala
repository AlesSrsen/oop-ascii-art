package converters.image.gray

import asciiApp.models.image.Image
import asciiApp.models.pixels.{GrayscalePixel, RGBPixel}
import converters.image.ImageToImageConverter

/**
 * Converts an Image[RGBPixel] to an Image[GrayscalePixel]
 * Converts based on the formula: gray = 0.3 * red + 0.59 * green + 0.11 * blue
 * @see [[https://www.tutorialspoint.com/dip/grayscale_to_rgb_conversion.htm]]
 */
class RGBImageToGrayscaleImageConverter
    extends ImageToImageConverter[Image[RGBPixel], Image[GrayscalePixel]] {
  override def convert(input: Image[RGBPixel]): Image[GrayscalePixel] = {
    val pixels = input.pixels.mapPixelsGrid(pixel => {
      val gray = (0.3 * pixel.red) + (0.59 * pixel.green) + (0.11 * pixel.blue)
      GrayscalePixel.corrected(gray.toInt)
    })
    new Image(pixels)
  }
}
