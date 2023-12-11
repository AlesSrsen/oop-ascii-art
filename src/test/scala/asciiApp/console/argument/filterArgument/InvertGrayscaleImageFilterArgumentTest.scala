package asciiApp.console.argument.filterArgument

import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter
import filters.image.gray.InvertGrayscaleImageFilter
import org.scalatest.FunSuite

class InvertGrayscaleImageFilterArgumentTest extends FunSuite {
  test("Parse argument") {
    val argument = new InvertGrayscaleImageFilterArgument
    val args = Seq("--invert")
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(result._1.get.isInstanceOf[ImageFilter[Image[GrayscalePixel]]])
    assert(result._1.get.isInstanceOf[InvertGrayscaleImageFilter])
  }

  test("Try to parse other arguments") {
    val argument = new InvertGrayscaleImageFilterArgument
    val args = Seq("--other-argument", "--invert")
    val result = argument.getResult(args)
    assert(result._1.isEmpty)
    assert(result._2.size == 2)
  }

  test("Get specification") {
    val argument = new InvertGrayscaleImageFilterArgument
    val specification = argument.specification()
    assert(specification == Seq("--invert"))
  }
}
