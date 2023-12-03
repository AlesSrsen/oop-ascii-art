package exporters.image

import java.io.{File, FileOutputStream}

class FileAsciiImageExporter(file: File)
    extends StreamAsciiImageExporter(new FileOutputStream(file)) {}
