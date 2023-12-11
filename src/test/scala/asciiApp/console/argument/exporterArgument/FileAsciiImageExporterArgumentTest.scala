package asciiApp.console.argument.exporterArgument

import asciiApp.console.exceptions.MissingArgumentOptionException
import asciiApp.models.image.Image
import asciiApp.models.pixels.AsciiPixel
import exporters.image.ImageExporter
import helpers.TestWithFiles
import org.scalatest.FunSuite

class FileAsciiImageExporterArgumentTest extends FunSuite with TestWithFiles {
  test("Parse argument") {
    val argument = new FileAsciiImageExporterArgument
    val tempFile = getRandomNonExistingTempFile()
    val args =
      Seq("--output-file", tempFile.getAbsolutePath)
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(result._1.get.isInstanceOf[ImageExporter[Image[AsciiPixel]]])
    deleteFile(tempFile)
  }

  test("Parse argument with missing path") {
    val argument = new FileAsciiImageExporterArgument
    val args = Seq("--output-file")
    assertThrows[MissingArgumentOptionException] {
      argument.getResult(args)
    }
  }

  test("Try to parse other arguments") {
    val argument = new FileAsciiImageExporterArgument
    val args = Seq(
      "--other-argument",
      "--output-file",
      getRandomNonExistingTempFile().getAbsolutePath)
    val result = argument.getResult(args)
    assert(result._1.isEmpty)
    assert(result._2.size == 3)
  }

  test("Parse argument alias") {
    val argument = new FileAsciiImageExporterArgument
    val tempFile = getRandomNonExistingTempFile()
    val args =
      Seq("-o", tempFile.getAbsolutePath)
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(result._1.get.isInstanceOf[ImageExporter[Image[AsciiPixel]]])
    deleteFile(tempFile)
  }

  test("Get specification") {
    val argument = new FileAsciiImageExporterArgument
    val specification = argument.specification()
    assert(specification == Seq("--output-file", "-o", "<path>"))
  }
}
