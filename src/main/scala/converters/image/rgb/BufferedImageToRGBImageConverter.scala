package converters.image.rgb

import asciiApp.models.grid.PixelGrid
import asciiApp.models.image.Image
import asciiApp.models.pixels.RGBPixel
import converters.Converter

import java.awt.image.BufferedImage

/**
 * Converts a Java BufferedImage to an Image[RGBPixel]
 * @see [[https://stackoverflow.com/questions/25761438/understanding-bufferedimage-getrgb-output-values]]
 */
class BufferedImageToRGBImageConverter
    extends Converter[BufferedImage, Image[RGBPixel]] {

  override def convert(input: BufferedImage): Image[RGBPixel] = {
    val pixelGrid = for (y <- 0 until input.getHeight)
      yield
        for (x <- 0 until input.getWidth) yield {
          val rgb = input.getRGB(x, y)
          val blue = rgb & 0xff
          val green = (rgb & 0xff00) >> 8
          val red = (rgb & 0xff0000) >> 16
          RGBPixel.corrected(red, green, blue)
        }
    new Image(new PixelGrid(pixelGrid))
  }
}
