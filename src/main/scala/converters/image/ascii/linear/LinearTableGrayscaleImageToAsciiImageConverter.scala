package converters.image.ascii.linear

import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter

trait LinearTableGrayscaleImageToAsciiImageConverter
    extends ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]] {
  val table: Seq[Char]

  override def convert(input: Image[GrayscalePixel]): Image[AsciiPixel] = {
    require(table.nonEmpty, "Table must not be empty")

    val asciiPixels = input.pixels.mapRowsGrid(_.map(pixel => {
      val bucketSize = GrayscalePixel.max().gray.toFloat / (table.length - 1)
      val index = pixel.gray.toFloat / bucketSize
      AsciiPixel(table(index.toInt))
    }))
    new Image(asciiPixels)
  }
}
