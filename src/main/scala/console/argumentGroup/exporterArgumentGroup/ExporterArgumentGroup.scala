package console.argumentGroup.exporterArgumentGroup

import console.argument.exporterArgument.{AsciiImageExporterArgument, FileAsciiImageExporterArgument, StdOutAsciiImageExporterArgument}
import console.argumentGroup.ArgumentGroup
import exporters.image.ImageExporter
import models.image.Image
import models.pixels.AsciiPixel

class ExporterArgumentGroup extends ArgumentGroup {

  override protected def arguments(): Seq[AsciiImageExporterArgument] =
    Seq(
      new FileAsciiImageExporterArgument,
      new StdOutAsciiImageExporterArgument)

  def getAsciiImageExporter(args: Seq[String])
    : (Option[ImageExporter[Image[AsciiPixel]]], Seq[String]) = {
    for (arg <- arguments()) {
      val (loader, newArgs) = arg.getAsciiImageExporter(args)
      if (loader.isDefined) return (Some(loader.get), newArgs)
    }
    (None, args)
  }

}
