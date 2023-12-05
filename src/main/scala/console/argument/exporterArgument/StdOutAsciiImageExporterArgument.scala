package console.argument.exporterArgument

import console.argument.ArgumentWithoutOptions
import exporters.image.{ImageExporter, StdOutAsciiImageExporter}
import models.image.Image
import models.pixels.AsciiPixel

class StdOutAsciiImageExporterArgument
    extends AsciiImageExporterArgument
    with ArgumentWithoutOptions {
  override def argumentName: String = "--output-console"

  override def getAsciiImageExporter(
    args: Args): (Option[ImageExporter[Image[AsciiPixel]]], Args) =
    getResultArgumentWitoutOptions(args, Some(new StdOutAsciiImageExporter))
}
