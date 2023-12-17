package asciiApp.console.argument.filterArgument

import asciiApp.console.exceptions.{InvalidArgumentOptionException, MissingArgumentOptionException}
import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter
import filters.image.generic.RotateImageFilter
import org.scalatest.FunSuite

class RotateGrayscaleImageFilterArgumentTest extends FunSuite {
  test("Parse argument between bounds") {
    val argument = new RotateGrayscaleImageFilterArgument
    for (i <- -360 to 360 by 90) {
      val args = Seq("--rotate", i.toString)
      val result = argument.getResult(args)
      assert(result._1.isDefined)
      assert(result._2.isEmpty)
      assert(result._1.get.isInstanceOf[ImageFilter[Image[GrayscalePixel]]])
      assert(result._1.get.isInstanceOf[RotateImageFilter[GrayscalePixel]])
    }
  }

  test("Parse argument with missing amount") {
    val argument = new RotateGrayscaleImageFilterArgument
    val args = Seq("--rotate")
    assertThrows[MissingArgumentOptionException] {
      argument.getResult(args)
    }
  }

  test("Parse argument with invalid amount") {
    val argument = new RotateGrayscaleImageFilterArgument
    val args = Seq("--rotate", "invalid")
    assertThrows[InvalidArgumentOptionException] {
      argument.getResult(args)
    }
  }

  test("Parse argument with value out of bounds") {
    val argument = new RotateGrayscaleImageFilterArgument
    val args = Seq("--rotate", "91")
    assertThrows[InvalidArgumentOptionException] {
      argument.getResult(args)
    }
  }

  test("Try to parse other arguments") {
    val argument = new RotateGrayscaleImageFilterArgument
    val args = Seq("--other-argument", "--rotate", "1")
    val result = argument.getResult(args)
    assert(result._1.isEmpty)
    assert(result._2.size == 3)
  }

  test("Get specification") {
    val argument = new RotateGrayscaleImageFilterArgument
    val specification = argument.specification()
    assert(specification.head == "--rotate")
    assert(specification(1) == "<-360/+360>")
    assert(specification.last == "Must be a multiple of 90")
  }
}
