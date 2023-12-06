package exporters.text

import java.io.OutputStream

/**
 * Export strings to an output stream
 * @param outputStream The output stream to export to
 */
class StreamTextExporter(outputStream: OutputStream) extends TextExporter {
  private var closed = false

  /**
   * Close the output stream
   */
  def close(): Unit = {
    if (closed)
      return

    outputStream.close()
    closed = true
  }

  /**
   * Export a string to the output stream
   * @param item The string to export
   */
  override def export(item: String): Unit = {
    if (closed)
      throw new IllegalStateException("The stream was already closed")

    outputStream.write(item.getBytes("UTF-8"))
    outputStream.flush()
  }
}
