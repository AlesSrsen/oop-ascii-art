package console.argument.exporterArgument

import console.argument.ArgumentWithoutOptions
import exporters.image.{ImageExporter, StdOutAsciiImageExporter}
import models.image.AsciiImage

class StdOutAsciiImageExporterArgument
    extends AsciiImageExporterArgument
    with ArgumentWithoutOptions {
  override def argumentName: String = "--output-console"

  override def getAsciiImageExporter(
    args: Args): (Option[ImageExporter[AsciiImage]], Args) =
    getResultArgumentWitoutOptions(args, Some(new StdOutAsciiImageExporter))
}
