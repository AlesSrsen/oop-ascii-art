package converters.image.ascii.linear

import converters.image.ImageToImageConverter
import models.image.{AsciiImage, GrayscaleImage}
import models.pixels.{AsciiPixel, GrayscalePixel}

trait LinearTableGrayscaleImageToAsciiImageConverter
    extends ImageToImageConverter[GrayscaleImage, AsciiImage] {
  val table: Seq[Char]

  override def convert(input: GrayscaleImage): AsciiImage = {
    require(table.nonEmpty, "Table must not be empty")

    val asciiPixels = input.mapRows(_.map(pixel => {
      val bucketSize = GrayscalePixel.max().gray.toFloat / (table.length - 1)
      val index = pixel.gray.toFloat / bucketSize
      AsciiPixel(table(index.toInt))
    }))
    new AsciiImage(asciiPixels)
  }
}
