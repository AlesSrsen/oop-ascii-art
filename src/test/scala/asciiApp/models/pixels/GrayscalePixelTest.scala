package asciiApp.models.pixels

import org.scalatest.FunSuite

class GrayscalePixelTest extends FunSuite {
  test("Invalid value below minimum") {
    assertThrows[IllegalArgumentException] {
      GrayscalePixel(-1)
    }
  }

  test("Invalid value above maximum") {
    assertThrows[IllegalArgumentException] {
      GrayscalePixel(256)
    }
  }

  test("Valid value") {
    assert(GrayscalePixel(0).gray == 0)
  }

  test("Correct value below minimum") {
    assert(GrayscalePixel.corrected(-1) == GrayscalePixel(0))
  }

  test("Correct value above maximum") {
    assert(GrayscalePixel.corrected(256) == GrayscalePixel(255))
  }

  test("Correct value") {
    assert(GrayscalePixel.corrected(0) == GrayscalePixel(0))
  }

  test("Min value") {
    assert(GrayscalePixel.min() == GrayscalePixel(0))
  }

  test("Max value") {
    assert(GrayscalePixel.max() == GrayscalePixel(255))
  }
}
