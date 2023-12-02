package exporters.image

import exporters.text.StreamTextExporter
import models.image.AsciiImage

import java.io.OutputStream

class AsciiImageExporter(outputStream: OutputStream)
    extends ImageExporter[AsciiImage] {
  def export(image: AsciiImage): Unit =
    new StreamTextExporter(outputStream).export(
      image.pixels
        .map(
          row =>
            row
              .map(pixel => pixel.getString)
              .mkString(""))
        .mkString(System.lineSeparator()))
}
