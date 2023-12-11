package asciiApp.console.argument.exporterArgument

import asciiApp.models.image.Image
import asciiApp.models.pixels.AsciiPixel
import exporters.image.ImageExporter
import org.scalatest.FunSuite

class StdOutAsciiImageExporterArgumentTest extends FunSuite {
  test("Parse argument") {
    val argument = new StdOutAsciiImageExporterArgument
    val args = Seq("--output-console")
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(result._1.get.isInstanceOf[ImageExporter[Image[AsciiPixel]]])
  }

  test("Try to parse other arguments") {
    val argument = new StdOutAsciiImageExporterArgument
    val args = Seq("--other-argument", "--output-console")
    val result = argument.getResult(args)
    assert(result._1.isEmpty)
    assert(result._2.size == 2)
  }

  test("Get specification") {
    val argument = new StdOutAsciiImageExporterArgument
    val specification = argument.specification()
    assert(specification == Seq("--output-console"))
  }
}
