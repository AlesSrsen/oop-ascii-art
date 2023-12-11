package asciiApp.console.argument.loaderArgument

import asciiApp.console.exceptions.{InvalidArgumentOptionException, MissingArgumentOptionException}
import helpers.TestWithFiles
import loaders.image.file.{GIFRGBImageFileLoader, JPGRGBImageFileLoader, PNGRGBImageFileLoader}
import org.scalatest.FunSuite

class FileRGBImageLoaderArgumentTest extends FunSuite with TestWithFiles {
  test("Parse argument with png image") {
    val argument = new FileRGBImageLoaderArgument
    val args = Seq(
      "--image",
      getImageFromResources("testing_grid_image.png").getAbsolutePath)
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(result._1.get.isInstanceOf[PNGRGBImageFileLoader])
  }

  test("Parse argument with jpg image") {
    val argument = new FileRGBImageLoaderArgument
    val args = Seq(
      "--image",
      getImageFromResources("testing_grid_image.jpg").getAbsolutePath)
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(result._1.get.isInstanceOf[JPGRGBImageFileLoader])
  }

  test("Parse argument with gif image") {
    val argument = new FileRGBImageLoaderArgument
    val args = Seq(
      "--image",
      getImageFromResources("testing_grid_image.gif").getAbsolutePath)
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(result._1.get.isInstanceOf[GIFRGBImageFileLoader])
  }

  test("Try to parse other arguments") {
    val argument = new FileRGBImageLoaderArgument
    val args = Seq(
      "--other-argument",
      "--image",
      getImageFromResources("testing_grid_image.png").getAbsolutePath)
    val result = argument.getResult(args)
    assert(result._1.isEmpty)
    assert(result._2.size == 3)
  }

  test("Try to parse without path") {
    val argument = new FileRGBImageLoaderArgument
    val args = Seq("--image")
    assertThrows[MissingArgumentOptionException] {
      argument.getResult(args)
    }
  }

  test("Try to parse with wrong extension") {
    val argument = new FileRGBImageLoaderArgument
    val args =
      Seq("--image", getRandomNonExistingTempFile(".xyz").getAbsolutePath)
    assertThrows[InvalidArgumentOptionException] {
      argument.getResult(args)
    }
  }

  test("Parse argument with png image using -i alias") {
    val argument = new FileRGBImageLoaderArgument
    val args =
      Seq("-i", getImageFromResources("testing_grid_image.png").getAbsolutePath)
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(result._1.get.isInstanceOf[PNGRGBImageFileLoader])
  }

  test("Get specification") {
    val argument = new FileRGBImageLoaderArgument
    val specification = argument.specification()
    assert(specification == Seq("--image", "-i", "<path>"))
  }
}
