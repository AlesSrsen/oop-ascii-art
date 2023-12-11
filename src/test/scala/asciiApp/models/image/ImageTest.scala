package asciiApp.models.image

import asciiApp.models.grid.PixelGrid
import asciiApp.models.pixels.AsciiPixel
import org.scalatest.FunSuite

class ImageTest extends FunSuite {
  test("Width and height") {
    val image = new Image(
      new PixelGrid(
        Seq(
          Seq(AsciiPixel('a'), AsciiPixel('b')),
          Seq(AsciiPixel('c'), AsciiPixel('d')),
          Seq(AsciiPixel('e'), AsciiPixel('f'))
        )
      )
    )
    assert(image.width == 2)
    assert(image.height == 3)
  }

  test("Get pixel using apply") {
    val image = new Image(
      new PixelGrid(
        Seq(
          Seq(AsciiPixel('a'), AsciiPixel('b')),
          Seq(AsciiPixel('c'), AsciiPixel('d')),
          Seq(AsciiPixel('e'), AsciiPixel('f'))
        )
      )
    )
    assert(image(0, 0) == AsciiPixel('a'))
    assert(image(0, 1) == AsciiPixel('b'))
    assert(image(1, 0) == AsciiPixel('c'))
    assert(image(1, 1) == AsciiPixel('d'))
    assert(image(2, 0) == AsciiPixel('e'))
    assert(image(2, 1) == AsciiPixel('f'))
  }
}
