package asciiApp.console.argument.filterArgument

import asciiApp.console.exceptions.{InvalidArgumentOptionException, MissingArgumentOptionException}
import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter
import filters.image.gray.BrightnessGrayscaleImageFilter
import org.scalatest.FunSuite

class BrightnessGrayscaleImageFilterArgumentTest extends FunSuite {
  test("Parse argument") {
    val argument = new BrightnessGrayscaleImageFilterArgument
    val args = Seq("--brightness", "1")
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(result._1.get.isInstanceOf[ImageFilter[Image[GrayscalePixel]]])
    assert(result._1.get.isInstanceOf[BrightnessGrayscaleImageFilter])
  }

  test("Parse argument with missing amount") {
    val argument = new BrightnessGrayscaleImageFilterArgument
    val args = Seq("--brightness")
    assertThrows[MissingArgumentOptionException] {
      argument.getResult(args)
    }
  }

  test("Parse argument with invalid amount") {
    val argument = new BrightnessGrayscaleImageFilterArgument
    val args = Seq("--brightness", "invalid")
    assertThrows[InvalidArgumentOptionException] {
      argument.getResult(args)
    }
  }

  test("Try to parse other arguments") {
    val argument = new BrightnessGrayscaleImageFilterArgument
    val args = Seq("--other-argument", "--brightness", "1")
    val result = argument.getResult(args)
    assert(result._1.isEmpty)
    assert(result._2.size == 3)
  }

  test("Get specification") {
    val argument = new BrightnessGrayscaleImageFilterArgument
    val specification = argument.specification()
    assert(specification.size == 2)
    assert(specification.head == "--brightness")
    assert(specification.last == "<-255/+255>")
  }
}
