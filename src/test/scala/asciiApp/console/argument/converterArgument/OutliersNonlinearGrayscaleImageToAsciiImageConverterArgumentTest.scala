package asciiApp.console.argument.converterArgument

import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter
import converters.image.ascii.nonlinear.OutliersNonlinearGrayscaleImageToAsciiImageConverter
import org.scalatest.FunSuite

class OutliersNonlinearGrayscaleImageToAsciiImageConverterArgumentTest
    extends FunSuite {
  test("Parse argument") {
    val argument =
      new OutliersNonlinearGrayscaleImageToAsciiImageConverterArgument
    val args = Seq("--nonlinear-outliers")
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(
      result._1.get.isInstanceOf[
        ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]])
    assert(
      result._1.get
        .isInstanceOf[OutliersNonlinearGrayscaleImageToAsciiImageConverter])
  }

  test("Try to parse other arguments") {
    val argument =
      new OutliersNonlinearGrayscaleImageToAsciiImageConverterArgument
    val args = Seq("--other-argument", "--nonlinear-outliers")
    val result = argument.getResult(args)
    assert(result._1.isEmpty)
    assert(result._2.size == 2)
  }

  test("Get specification") {
    val argument =
      new OutliersNonlinearGrayscaleImageToAsciiImageConverterArgument
    val specification = argument.specification()
    assert(specification == Seq("--nonlinear-outliers"))
  }
}
