package converters.image.ascii.linear

import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter

/**
 * Converts an Image[GrayscalePixel] to an Image[AsciiPixel]
 * Converts images based on a linear mapping of values to characters
 */
trait LinearTableGrayscaleImageToAsciiImageConverter
    extends ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]] {

  /**
   * Table of characters used for conversion
   */
  val table: Seq[Char]

  /**
   * Converts an Image[GrayscalePixel] to an Image[AsciiPixel]
   * @param input input
   * @return converted output
   */
  override def convert(input: Image[GrayscalePixel]): Image[AsciiPixel] = {
    require(table.nonEmpty, "Table must not be empty")
    val asciiPixels = input.pixels.mapPixelsGrid(pixel => {
      // There are 256 distinct values of brightness in GrayscalePixel
      // We calculate the size of each bucket
      val bucketSize =
        ((GrayscalePixel.max().gray + 1) / table.length.toDouble).ceil
      // We calculate the index of the bucket in which the value of brightness falls
      val index = (pixel.gray.toFloat / bucketSize).floor.toInt
      AsciiPixel(table(index))
    })
    new Image(asciiPixels)
  }
}
