package exporters.text

import java.io.{File, FileOutputStream}

class FileExporter(file: File)
    extends StreamTextExporter(new FileOutputStream(file)) {}
