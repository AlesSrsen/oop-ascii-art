package exporters.text

import java.io.OutputStream

/**
 * Exports text to standard output.
 */
class StdOutTextExporter(stdOutOutputStream: OutputStream = System.out)
    extends StreamTextExporter(stdOutOutputStream) {

  /**
   * Do not close standard output.
   * Closing it could cause problems for other parts of the application.
   */
  override def close(): Unit =
    closed = true
}
