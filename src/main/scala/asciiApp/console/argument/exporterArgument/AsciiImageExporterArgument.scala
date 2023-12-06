package asciiApp.console.argument.exporterArgument

import asciiApp.console.argument.Argument
import asciiApp.models.image.Image
import asciiApp.models.pixels.AsciiPixel
import exporters.image.{ImageExporter, StreamAsciiImageExporter}

trait AsciiImageExporterArgument
    extends Argument[StreamAsciiImageExporter] {}
