package asciiApp.models.pixels

import org.scalatest.FunSuite

class RGBPixelTest extends FunSuite {
  test("Invalid value below minimum") {
    assertThrows[IllegalArgumentException] {
      RGBPixel(-1, -1, -1)
    }
  }

  test("Invalid value above maximum") {
    assertThrows[IllegalArgumentException] {
      RGBPixel(256, 256, 256)
    }
  }

  test("Valid value") {
    val pixel = RGBPixel(0, 0, 0)
    assert(pixel.red == 0)
    assert(pixel.green == 0)
    assert(pixel.blue == 0)
  }

  test("Correct value below minimum") {
    assert(RGBPixel.corrected(-1, -1, -1) == RGBPixel(0, 0, 0))
  }

  test("Correct value above maximum") {
    assert(RGBPixel.corrected(256, 256, 256) == RGBPixel(255, 255, 255))
  }

  test("Correct value") {
    assert(RGBPixel.corrected(0, 0, 0) == RGBPixel(0, 0, 0))
  }

  test("Min value") {
    assert(RGBPixel.min() == RGBPixel(0, 0, 0))
  }

  test("Max value") {
    assert(RGBPixel.max() == RGBPixel(255, 255, 255))
  }
}
