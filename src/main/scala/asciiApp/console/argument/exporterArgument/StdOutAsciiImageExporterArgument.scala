package asciiApp.console.argument.exporterArgument

import asciiApp.console.argument.ArgumentWithoutOptions
import asciiApp.models.image.Image
import asciiApp.models.pixels.AsciiPixel
import exporters.image.{ImageExporter, StdOutAsciiImageExporter}

class StdOutAsciiImageExporterArgument
    extends AsciiImageExporterArgument
    with ArgumentWithoutOptions[ImageExporter[Image[AsciiPixel]]] {
  override def argumentName: String = "--output-console"

  override protected def createInstance: ImageExporter[Image[AsciiPixel]] =
    new StdOutAsciiImageExporter
}
