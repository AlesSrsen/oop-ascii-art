package asciiApp.console.argument.filterArgument

import asciiApp.console.exceptions.{InvalidArgumentOptionException, MissingArgumentOptionException}
import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter
import filters.image.generic.flip.{XFlipImageFilter, YFlipImageFilter}
import filters.image.gray.BrightnessGrayscaleImageFilter
import org.scalatest.FunSuite

class FlipGrayscaleImageFilterArgumentTest extends FunSuite {
  test("Parse argument with y flip") {
    val argument = new FlipGrayscaleImageFilterArgument
    val args = Seq("--flip", "y")
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(result._1.get.isInstanceOf[ImageFilter[Image[GrayscalePixel]]])
    assert(result._1.get.isInstanceOf[YFlipImageFilter[GrayscalePixel]])
  }

  test("Parse argument with x flip") {
    val argument = new FlipGrayscaleImageFilterArgument
    val args = Seq("--flip", "x")
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(result._1.get.isInstanceOf[ImageFilter[Image[GrayscalePixel]]])
    assert(result._1.get.isInstanceOf[XFlipImageFilter[GrayscalePixel]])
  }

  test("Parse argument with missing direction") {
    val argument = new FlipGrayscaleImageFilterArgument
    val args = Seq("--flip")
    assertThrows[MissingArgumentOptionException] {
      argument.getResult(args)
    }
  }

  test("Parse argument with invalid direction") {
    val argument = new FlipGrayscaleImageFilterArgument
    val args = Seq("--flip", "z")
    assertThrows[InvalidArgumentOptionException] {
      argument.getResult(args)
    }
  }

  test("Try to parse other arguments") {
    val argument = new FlipGrayscaleImageFilterArgument
    val args = Seq("--other-argument", "--flip", "y")
    val result = argument.getResult(args)
    assert(result._1.isEmpty)
    assert(result._2.size == 3)
  }

  test("Get specification") {
    val argument = new FlipGrayscaleImageFilterArgument
    val specification = argument.specification()
    assert(specification == Seq("--flip", "<x/y>"))
  }
}
