package console.argument.exporterArgument

import console.argument.Argument
import exporters.image.ImageExporter
import models.image.Image
import models.pixels.AsciiPixel

trait AsciiImageExporterArgument
    extends Argument[ImageExporter[Image[AsciiPixel]]] {}
