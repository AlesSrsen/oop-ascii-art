package asciiApp.console.argument.converterArgument

import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter
import converters.image.ascii.linear.ShortBourkeGrayscaleImageToAsciiImageConverter
import org.scalatest.FunSuite

class ShortBourkeGrayscaleImageToAsciiImageConverterArgumentTest
    extends FunSuite {
  test("Parse argument") {
    val argument = new ShortBourkeGrayscaleImageToAsciiImageConverterArgument
    val args = Seq("--table-short-bourke")
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(
      result._1.get.isInstanceOf[
        ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]])
    assert(
      result._1.get
        .isInstanceOf[ShortBourkeGrayscaleImageToAsciiImageConverter])
  }

  test("Try to parse other arguments") {
    val argument = new ShortBourkeGrayscaleImageToAsciiImageConverterArgument
    val args = Seq("--other-argument", "--table-short-bourke")
    val result = argument.getResult(args)
    assert(result._1.isEmpty)
    assert(result._2.size == 2)
  }

  test("Get specification") {
    val argument = new ShortBourkeGrayscaleImageToAsciiImageConverterArgument
    val specification = argument.specification()
    assert(specification == Seq("--table-short-bourke"))
  }
}
