package loaders.image.random

import org.scalatest.FunSuite

import scala.util.Random

class RGBImageRandomLoaderTest extends FunSuite {
  test("Load random Image[RGBPixel] with random pixels") {
    val random = new Random()
    val loader = new RGBImageRandomLoader(random)
    val image = loader.load()
    assert(image.width > 0)
    assert(image.height > 0)
    for (row <- 0 until image.height)
      for (col <- 0 until image.width) {
        val pixel = image(row, col)
        assert(pixel.red >= 0)
        assert(pixel.red < 256)
        assert(pixel.green >= 0)
        assert(pixel.green < 256)
        assert(pixel.blue >= 0)
        assert(pixel.blue < 256)
      }
  }
}
