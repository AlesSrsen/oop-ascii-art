package exporters.text

import java.io.OutputStream

/**
 * Exports text to standard output.
 */
class StdOutTextExporter(stdOutOutputStream: OutputStream = System.out) extends StreamTextExporter(stdOutOutputStream) {}
