package asciiApp.models.pixels

import org.scalatest.FunSuite

class AsciiPixelTest extends FunSuite {
  test("Get string") {
    assert(AsciiPixel('a').getString == "a")
  }
}
