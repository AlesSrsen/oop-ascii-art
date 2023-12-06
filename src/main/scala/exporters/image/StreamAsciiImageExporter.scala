package exporters.image

import asciiApp.models.image.Image
import asciiApp.models.pixels.AsciiPixel
import exporters.text.StreamTextExporter

import java.io.OutputStream

/**
 * Exports an ascii image to a stream
 * @param outputStream The stream to export to
 */
class StreamAsciiImageExporter(outputStream: OutputStream)
    extends ImageExporter[Image[AsciiPixel]] {

  private val streamTextExporter = new StreamTextExporter(outputStream)

  /**
   * Export an ascii image to a stream
   * @param image The image to export
   */
  def export(image: Image[AsciiPixel]): Unit =
    streamTextExporter.export(
      image.pixels
        .mapRows(
          row =>
            row
              .map(pixel => pixel.getString)
              .mkString(""))
        .mkString(System.lineSeparator()))

  /**
   * Close the stream
   */
  def close(): Unit = streamTextExporter.close()
}
