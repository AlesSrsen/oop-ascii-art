package console.argumentGroup.exporterArgumentGroup

import console.argument.exporterArgument.{AsciiImageExporterArgument, FileAsciiImageExporterArgument, StdOutAsciiImageExporterArgument}
import console.argumentGroup.ArgumentGroup
import exporters.image.ImageExporter
import models.image.Image
import models.pixels.AsciiPixel

class AsciiImageExporterArgumentGroup
    extends ArgumentGroup[ImageExporter[Image[AsciiPixel]]] {

  override protected def arguments(): Seq[AsciiImageExporterArgument] =
    Seq(
      new FileAsciiImageExporterArgument,
      new StdOutAsciiImageExporterArgument)
}
