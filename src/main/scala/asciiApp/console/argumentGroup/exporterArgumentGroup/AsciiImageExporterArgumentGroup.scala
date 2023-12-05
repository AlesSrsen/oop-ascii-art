package asciiApp.console.argumentGroup.exporterArgumentGroup

import asciiApp.console.argument.exporterArgument.{AsciiImageExporterArgument, FileAsciiImageExporterArgument, StdOutAsciiImageExporterArgument}
import asciiApp.console.argumentGroup.ArgumentGroup
import asciiApp.models.image.Image
import asciiApp.models.pixels.AsciiPixel
import exporters.image.ImageExporter

class AsciiImageExporterArgumentGroup
    extends ArgumentGroup[ImageExporter[Image[AsciiPixel]]] {

  override protected def arguments(): Seq[AsciiImageExporterArgument] =
    Seq(
      new FileAsciiImageExporterArgument,
      new StdOutAsciiImageExporterArgument)
}
