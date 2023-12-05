package exporters.image

import asciiApp.models.image.Image
import asciiApp.models.pixels.AsciiPixel
import exporters.text.StreamTextExporter

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
