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
    val asciiPixels = input.pixels.mapPixelsGrid(
      pixel =>
        AsciiPixel(
          table(
            mapRangeToRange(
              pixel.gray,
              GrayscalePixel.min().gray,
              GrayscalePixel.max().gray,
              0,
              table.length - 1))))
    new Image(asciiPixels)
  }

  /**
   * Maps a value from one range to another
   * @param x value to map
   * @param in_min minimum value of input range
   * @param in_max maximum value of input range
   * @param out_min minimum value of output range
   * @param out_max maximum value of output range
   * @return mapped value
   */
  private def mapRangeToRange(
    x: Int,
    in_min: Int,
    in_max: Int,
    out_min: Int,
    out_max: Int): Int = {
    val d_x: Double = x.toDouble
    val d_in_min: Double = in_min.toDouble
    val d_in_max: Double = in_max.toDouble
    val d_out_min: Double = out_min.toDouble
    val d_out_max: Double = out_max.toDouble
    ((d_x - d_in_min) * (d_out_max - d_out_min) / (d_in_max - d_in_min) + d_out_min).round.toInt
  }
}
