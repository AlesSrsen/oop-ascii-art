package console.argument.exporterArgument

import exporters.image.{FileAsciiImageExporter, ImageExporter}
import models.image.AsciiImage

import java.io.File

class FileAsciiImageExporterArgument extends AsciiImageExporterArgument {
  override def parseTopAndPop(args: Args): (Boolean, Args) =
    if (args.nonEmpty && args.head == argumentName) {
      if (args.length < 2)
        throw new IllegalArgumentException("No path to image")
      if (new File(args(1)).exists())
        throw new IllegalArgumentException("File already exists")
      (true, args.drop(2))
    } else
      (false, args)

  override def specification(): Seq[String] =
    Seq(argumentName, "path to create output file")

  override def argumentName: String = "--output-file"

  override def getAsciiImageExporter(
    args: Args): (Option[ImageExporter[AsciiImage]], Args) = {
    val (isParsed, _) = parseTopAndPop(args)
    if (isParsed)
      (Some(new FileAsciiImageExporter(new File(args(1)))), args.drop(2))
    else
      (None, args)
  }
}
