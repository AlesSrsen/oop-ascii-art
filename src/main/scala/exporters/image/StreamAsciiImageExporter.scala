package exporters.image

import exporters.text.StreamTextExporter
import models.image.Image
import models.pixels.AsciiPixel

import java.io.OutputStream

class StreamAsciiImageExporter(outputStream: OutputStream)
    extends ImageExporter[Image[AsciiPixel]] {
  def export(image: Image[AsciiPixel]): Unit =
    new StreamTextExporter(outputStream).export(
      image.pixels
        .mapRows(
          row =>
            row
              .map(pixel => pixel.getString)
              .mkString(""))
        .mkString(System.lineSeparator()))
}
