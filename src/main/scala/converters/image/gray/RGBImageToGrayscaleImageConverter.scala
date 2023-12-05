package converters.image.gray

import converters.image.ImageToImageConverter
import models.image.Image
import models.pixels.{GrayscalePixel, RGBPixel}

class RGBImageToGrayscaleImageConverter
    extends ImageToImageConverter[Image[RGBPixel], Image[GrayscalePixel]] {
  override def convert(input: Image[RGBPixel]): Image[GrayscalePixel] = {
    val pixels = input.pixels.mapRowsGrid(_.map(pixel => {
      val gray = ((0.3 * pixel.red) + (0.59 * pixel.green) + (0.11 * pixel.blue))
      GrayscalePixel(gray.toInt)
    }))
    new Image(pixels)
  }
}
