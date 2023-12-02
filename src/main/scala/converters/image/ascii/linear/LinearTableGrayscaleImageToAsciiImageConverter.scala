package converters.image.ascii.linear

import converters.image.ImageToImageConverter
import models.image.{AsciiImage, GrayscaleImage}
import models.pixels.AsciiPixel

trait LinearTableGrayscaleImageToAsciiImageConverter
    extends ImageToImageConverter[GrayscaleImage, AsciiImage] {
  val table: Seq[Char]

  override def convert(input: GrayscaleImage): AsciiImage = {
    val asciiPixels = input.pixels.map(_.map(pixel => {
      val bucketSize = 255.toFloat / (table.length - 1)
      val index = pixel.gray.toFloat / bucketSize
      AsciiPixel(table(index.toInt))
    }))
    new AsciiImage(asciiPixels)
  }
}
