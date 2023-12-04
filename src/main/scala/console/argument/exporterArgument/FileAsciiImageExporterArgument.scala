package console.argument.exporterArgument

import exporters.image.{FileAsciiImageExporter, ImageExporter}
import models.image.AsciiImage

import java.io.File

class FileAsciiImageExporterArgument extends AsciiImageExporterArgument {
  override def specification(): Seq[String] =
    Seq(argumentName, "path to create output file")

  override def argumentName: String = "--output-file"

  override def getAsciiImageExporter(
    args: Args): (Option[ImageExporter[AsciiImage]], Args) =
    getResult(
      args,
      (otherArgs: Args) => {
        if (otherArgs.length < 1)
          throw new IllegalArgumentException("No path to image")
        if (new File(otherArgs.head).exists())
          throw new IllegalArgumentException("File already exists")
        return (
          Some(new FileAsciiImageExporter(new File(otherArgs.head))),
          otherArgs.drop(1)
        )
      }
    )
}
