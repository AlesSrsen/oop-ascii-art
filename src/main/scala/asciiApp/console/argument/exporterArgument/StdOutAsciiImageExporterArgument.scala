package asciiApp.console.argument.exporterArgument

import asciiApp.console.argument.ArgumentWithoutOptions
import asciiApp.models.image.Image
import asciiApp.models.pixels.AsciiPixel
import exporters.image.{
  ImageExporter,
  StdOutAsciiImageExporter,
  StreamAsciiImageExporter
}

class StdOutAsciiImageExporterArgument
    extends AsciiImageExporterArgument
    with ArgumentWithoutOptions[StreamAsciiImageExporter] {
  override def argumentName: String = "--output-console"

  override protected def createInstance: StreamAsciiImageExporter =
    new StdOutAsciiImageExporter
}
