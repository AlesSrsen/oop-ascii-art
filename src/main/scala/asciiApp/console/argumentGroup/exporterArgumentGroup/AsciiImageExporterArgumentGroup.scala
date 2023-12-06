package asciiApp.console.argumentGroup.exporterArgumentGroup

import asciiApp.console.argument.exporterArgument.{AsciiImageExporterArgument, FileAsciiImageExporterArgument, StdOutAsciiImageExporterArgument}
import asciiApp.console.argumentGroup.ArgumentGroup
import asciiApp.models.image.Image
import asciiApp.models.pixels.AsciiPixel
import exporters.image.{ImageExporter, StreamAsciiImageExporter}

class AsciiImageExporterArgumentGroup
    extends ArgumentGroup[StreamAsciiImageExporter] {

  override protected def arguments(): Seq[AsciiImageExporterArgument] =
    Seq(
      new FileAsciiImageExporterArgument,
      new StdOutAsciiImageExporterArgument)
}
