package asciiApp.console.argument.converterArgument

import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter
import converters.image.ascii.nonlinear.DefaultNonlinearGrayscaleImageToAsciiImageConverter
import org.scalatest.FunSuite

class DefaultNonlinearGrayscaleImageToAsciiImageConverterArgumentTest
    extends FunSuite {
  test("Parse argument") {
    val argument =
      new DefaultNonlinearGrayscaleImageToAsciiImageConverterArgument
    val args = Seq("--nonlinear-default")
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(
      result._1.get.isInstanceOf[
        ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]])
    assert(
      result._1.get
        .isInstanceOf[DefaultNonlinearGrayscaleImageToAsciiImageConverter])
  }

  test("Try to parse other arguments") {
    val argument =
      new DefaultNonlinearGrayscaleImageToAsciiImageConverterArgument
    val args = Seq("--other-argument", "--nonlinear-default")
    val result = argument.getResult(args)
    assert(result._1.isEmpty)
    assert(result._2.size == 2)
  }

  test("Get specification") {
    val argument =
      new DefaultNonlinearGrayscaleImageToAsciiImageConverterArgument
    val specification = argument.specification()
    assert(specification == Seq("--nonlinear-default"))
  }
}
