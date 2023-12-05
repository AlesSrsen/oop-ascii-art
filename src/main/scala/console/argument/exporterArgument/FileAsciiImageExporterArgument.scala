package console.argument.exporterArgument

import exporters.image.{FileAsciiImageExporter, ImageExporter}
import models.image.Image
import models.pixels.AsciiPixel

import java.io.File

class FileAsciiImageExporterArgument extends AsciiImageExporterArgument {
  override def specification(): Seq[String] =
    super.specification().appended("<path>")

  override def argumentName: String = "--output-file"

  override def aliases: Seq[String] = Seq("-o")

  override protected def argOptionsReducer(
    argumentOptions: Seq[String]): (ImageExporter[Image[AsciiPixel]], Args) = {
    if (argumentOptions.length < 1)
      throw new IllegalArgumentException(
        "No path to output result supplied to: " + argumentName)
    (
      new FileAsciiImageExporter(new File(argumentOptions.head)),
      argumentOptions.drop(1)
    )
  }
}
