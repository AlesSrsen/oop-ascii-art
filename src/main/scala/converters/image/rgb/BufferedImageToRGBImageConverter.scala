package converters.image.rgb

import converters.Converter
import models.image.RGBImage
import models.pixels.RGBPixel

import java.awt.image.BufferedImage

class BufferedImageToRGBImageConverter
    extends Converter[BufferedImage, RGBImage] {
  override def convert(input: BufferedImage): RGBImage = {
    val pixelGrid = for (y <- 0 until input.getHeight)
      yield
        for (x <- 0 until input.getWidth) yield {
          val rgb = input.getRGB(x, y)
          val blue = rgb & 0xff
          val green = (rgb & 0xff00) >> 8
          val red = (rgb & 0xff0000) >> 16
          RGBPixel(red, green, blue)
        }
    new RGBImage(pixelGrid)
  }
}
