package asciiApp.console.argument.converterArgument

import asciiApp.console.exceptions.MissingArgumentOptionException
import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter
import converters.image.ascii.linear.CustomTableGrayscaleImageToAsciiImageConverter
import org.scalatest.FunSuite

class CustomTableGrayscaleImageToAsciiImageConverterArgumentTest
    extends FunSuite {
  test("Parse argument") {
    val argument = new CustomTableGrayscaleImageToAsciiImageConverterArgument
    val args =
      Seq("--table-custom", "xyz")
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(
      result._1.get.isInstanceOf[
        ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]])
    assert(
      result._1.get
        .isInstanceOf[CustomTableGrayscaleImageToAsciiImageConverter])
  }

  test("Parse argument with missing path") {
    val argument = new CustomTableGrayscaleImageToAsciiImageConverterArgument
    val args = Seq("--table-custom")
    assertThrows[MissingArgumentOptionException] {
      argument.getResult(args)
    }
  }

  test("Try to parse other arguments") {
    val argument = new CustomTableGrayscaleImageToAsciiImageConverterArgument
    val args = Seq("--other-argument", "--table-custom", "xyz")
    val result = argument.getResult(args)
    assert(result._1.isEmpty)
    assert(result._2.size == 3)
  }

  test("Get specification") {
    val argument = new CustomTableGrayscaleImageToAsciiImageConverterArgument
    val specification = argument.specification()
    assert(specification == Seq("--table-custom", "<table>"))
  }
}
