package console.argument.exporterArgument

import exporters.image.{ImageExporter, StdOutAsciiImageExporter}
import models.image.AsciiImage

class StdOutAsciiImageExporterArgument extends AsciiImageExporterArgument {
  override def argumentName: String = "--output-console"

  override def getAsciiImageExporter(
    args: Args): (Option[ImageExporter[AsciiImage]], Args) =
    getResult(args, Some(new StdOutAsciiImageExporter))
}
