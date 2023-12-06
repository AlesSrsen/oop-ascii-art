package asciiApp.console.argument.exporterArgument

import asciiApp.console.exceptions.MissingArgumentOptionException
import exporters.image.{FileAsciiImageExporter, StreamAsciiImageExporter}

import java.io.File

class FileAsciiImageExporterArgument extends AsciiImageExporterArgument {
  override def specification(): Seq[String] =
    super.specification().appended("<path>")

  override def aliases: Seq[String] = Seq("-o")

  override protected def argOptionsReducer(
    argumentOptions: Seq[String]): (StreamAsciiImageExporter, Args) = {
    if (argumentOptions.length < 1)
      throw new MissingArgumentOptionException(
        "No path to output result supplied to: " + argumentName)
    (
      new FileAsciiImageExporter(new File(argumentOptions.head)),
      argumentOptions.drop(1)
    )
  }

  override def argumentName: String = "--output-file"
}
