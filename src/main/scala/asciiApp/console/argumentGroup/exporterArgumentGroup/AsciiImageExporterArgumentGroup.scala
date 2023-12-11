package asciiApp.console.argumentGroup.exporterArgumentGroup

import asciiApp.console.argument.exporterArgument.{FileAsciiImageExporterArgument, StdOutAsciiImageExporterArgument}
import asciiApp.console.argumentGroup.ArgumentGroup
import exporters.image.StreamAsciiImageExporter

class AsciiImageExporterArgumentGroup
    extends ArgumentGroup[StreamAsciiImageExporter](
      Seq(
        new FileAsciiImageExporterArgument,
        new StdOutAsciiImageExporterArgument)) {}
