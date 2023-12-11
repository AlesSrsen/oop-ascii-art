package exporters.image

import asciiApp.models.image.Image
import asciiApp.models.pixels.AsciiPixel
import exporters.text.StreamTextExporter

/**
 * Exports an ascii image to a stream
 * @param streamTextExporter Exporter of text to stream, necessary to decide which stream to use
 */
class StreamAsciiImageExporter(streamTextExporter: StreamTextExporter)
    extends ImageExporter[Image[AsciiPixel]] {

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
