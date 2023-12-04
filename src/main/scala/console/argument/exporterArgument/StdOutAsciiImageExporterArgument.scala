package console.argument.exporterArgument

import console.argument.SingleArgument
import exporters.image.{ImageExporter, StdOutAsciiImageExporter}
import models.image.AsciiImage

class StdOutAsciiImageExporterArgument
    extends AsciiImageExporterArgument
    with SingleArgument {
  override def argumentName: String = "--output-console"

  override def getAsciiImageExporter(
    args: Args): (Option[ImageExporter[AsciiImage]], Args) =
    getResult(args, new StdOutAsciiImageExporter)
}
