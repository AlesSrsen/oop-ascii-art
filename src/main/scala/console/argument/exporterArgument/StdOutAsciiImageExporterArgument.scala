package console.argument.exporterArgument

import console.argument.ArgumentWithoutOptions
import exporters.image.{ImageExporter, StdOutAsciiImageExporter}
import models.image.Image
import models.pixels.AsciiPixel

class StdOutAsciiImageExporterArgument
    extends AsciiImageExporterArgument
    with ArgumentWithoutOptions[ImageExporter[Image[AsciiPixel]]] {
  override def argumentName: String = "--output-console"

  override protected def createInstance: ImageExporter[Image[AsciiPixel]] =
    new StdOutAsciiImageExporter
}
