package console.argument.exporterArgument

import console.argument.Argument
import exporters.image.ImageExporter
import models.image.Image
import models.pixels.AsciiPixel

trait AsciiImageExporterArgument extends Argument {
  def getAsciiImageExporter(
    args: Args): (Option[ImageExporter[Image[AsciiPixel]]], Args)
}
