package exporters.image

import java.io.{File, FileOutputStream}

class FileAsciiImageExporter(file: File)
    extends StreamAsciiImageExporter(new FileOutputStream(file)) {
  require(file.canWrite, "Unable to write to file")
}
