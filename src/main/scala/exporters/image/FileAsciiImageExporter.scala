package exporters.image

import java.io.{File, FileOutputStream}

/**
 * Exports ascii images to a file
 * @param file The file to write to
 */
class FileAsciiImageExporter(file: File)
    extends StreamAsciiImageExporter(new FileOutputStream(file)) {
  require(file.canWrite, "Unable to write to file")
}
