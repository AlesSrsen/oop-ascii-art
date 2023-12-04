package console.argument.exporterArgument

import console.argument.Argument
import exporters.image.ImageExporter
import models.image.AsciiImage

trait AsciiImageExporterArgument extends Argument {
  def getAsciiImageExporter(
    args: Args): (Option[ImageExporter[AsciiImage]], Args)
}
