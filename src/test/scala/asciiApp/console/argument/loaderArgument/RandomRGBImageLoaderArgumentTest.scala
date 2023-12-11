package asciiApp.console.argument.loaderArgument

import loaders.image.random.RGBImageRandomLoader
import org.scalatest.FunSuite

class RandomRGBImageLoaderArgumentTest extends FunSuite {
  test("Parse argument") {
    val argument = new RandomRGBImageLoaderArgument
    val args = Seq("--image-random")
    val result = argument.getResult(args)
    assert(result._1.isDefined)
    assert(result._2.isEmpty)
    assert(result._1.get.isInstanceOf[RGBImageRandomLoader])
  }

  test("Try to parse other arguments") {
    val argument = new RandomRGBImageLoaderArgument
    val args = Seq("--other-argument", "--image-random")
    val result = argument.getResult(args)
    assert(result._1.isEmpty)
    assert(result._2.size == 2)
  }

  test("Get specification") {
    val argument = new RandomRGBImageLoaderArgument
    val specification = argument.specification()
    assert(specification == Seq("--image-random"))
  }
}
