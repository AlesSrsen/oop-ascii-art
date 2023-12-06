package exporters.text

import java.io.{File, FileOutputStream}

/**
 * Exports text to a file
 * @param file The file to write to
 */
class FileTextExporter(file: File)
    extends StreamTextExporter(new FileOutputStream(file)) {
  require(file.canWrite, "Unable to write to file")
}
