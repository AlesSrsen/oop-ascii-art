package asciiApp.console.argument.exporterArgument

import asciiApp.console.argument.ArgumentWithoutOptions
import exporters.image.StreamAsciiImageExporter
import exporters.text.StdOutTextExporter

class StdOutAsciiImageExporterArgument
    extends AsciiImageExporterArgument
    with ArgumentWithoutOptions[StreamAsciiImageExporter] {
  override def argumentName: String = "--output-console"

  override protected def createInstance(): StreamAsciiImageExporter =
    new StreamAsciiImageExporter(new StdOutTextExporter)
}
