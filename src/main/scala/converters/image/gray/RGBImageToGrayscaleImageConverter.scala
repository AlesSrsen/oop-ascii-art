package converters.image.gray

import converters.image.ImageToImageConverter
import models.image.{GrayscaleImage, RGBImage}
import models.pixels.GrayscalePixel

class RGBImageToGrayscaleImageConverter
    extends ImageToImageConverter[RGBImage, GrayscaleImage] {
  override def convert(input: RGBImage): GrayscaleImage = {
    val pixels = input.pixels.mapRowsGrid(_.map(pixel => {
      val gray = ((0.3 * pixel.red) + (0.59 * pixel.green) + (0.11 * pixel.blue))
      GrayscalePixel(gray.toInt)
    }))
    new GrayscaleImage(pixels)
  }
}
