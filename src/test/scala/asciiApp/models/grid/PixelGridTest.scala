package asciiApp.models.grid

import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import org.scalatest.FunSuite

class PixelGridTest extends FunSuite {
  val testingSeq: Seq[Seq[AsciiPixel]] = Seq(
    Seq(AsciiPixel('a'), AsciiPixel('b')),
    Seq(AsciiPixel('c'), AsciiPixel('d')),
    Seq(AsciiPixel('e'), AsciiPixel('f'))
  )

  test("Height and width") {
    val pixelGrid = new PixelGrid(
      testingSeq
    )
    assert(pixelGrid.width == 2)
    assert(pixelGrid.height == 3)
  }

  test("Get pixel using apply") {
    val pixelGrid = new PixelGrid(
      testingSeq
    )
    assert(pixelGrid(0, 0) == AsciiPixel('a'))
    assert(pixelGrid(0, 1) == AsciiPixel('b'))
    assert(pixelGrid(1, 0) == AsciiPixel('c'))
    assert(pixelGrid(1, 1) == AsciiPixel('d'))
    assert(pixelGrid(2, 0) == AsciiPixel('e'))
    assert(pixelGrid(2, 1) == AsciiPixel('f'))
  }

  test("Reverse grid") {
    val pixelGrid = new PixelGrid(
      testingSeq
    )
    val reversedPixelGrid = pixelGrid.reverse()
    assert(reversedPixelGrid(0)(0) == AsciiPixel('e'))
    assert(reversedPixelGrid(0)(1) == AsciiPixel('f'))
    assert(reversedPixelGrid(1)(0) == AsciiPixel('c'))
    assert(reversedPixelGrid(1)(1) == AsciiPixel('d'))
    assert(reversedPixelGrid(2)(0) == AsciiPixel('a'))
    assert(reversedPixelGrid(2)(1) == AsciiPixel('b'))
  }

  test("Reversed grid") {
    val pixelGrid = new PixelGrid(
      testingSeq
    )
    val reversedPixelGrid = pixelGrid.reversedGrid()
    assert(reversedPixelGrid(0, 0) == AsciiPixel('e'))
    assert(reversedPixelGrid(0, 1) == AsciiPixel('f'))
    assert(reversedPixelGrid(1, 0) == AsciiPixel('c'))
    assert(reversedPixelGrid(1, 1) == AsciiPixel('d'))
    assert(reversedPixelGrid(2, 0) == AsciiPixel('a'))
    assert(reversedPixelGrid(2, 1) == AsciiPixel('b'))
  }

  test("Get pixel seq") {
    val pixelGrid = new PixelGrid(
      testingSeq
    )
    assert(pixelGrid.getPixelSeq == testingSeq)
  }

  test("Map pixels grid") {
    val pixelGrid = new PixelGrid(
      testingSeq
    )
    val mappedPixelGrid =
      pixelGrid.mapPixelsGrid(_ => new GrayscalePixel(0))
    assert(
      mappedPixelGrid.getPixelSeq.flatten == Seq.fill(6)(new GrayscalePixel(0)))
  }

  test("Map rows grid") {
    val pixelGrid = new PixelGrid(
      testingSeq
    )
    val mappedPixelGrid =
      pixelGrid.mapRowsGrid(_ => Seq.fill(2)(new GrayscalePixel(0)))
    assert(
      mappedPixelGrid.getPixelSeq.flatten == Seq.fill(6)(new GrayscalePixel(0)))
  }

  test("Map pixels") {
    val pixelGrid = new PixelGrid(
      testingSeq
    )
    val mappedPixels =
      pixelGrid.mapPixels(_ => "px")
    assert(mappedPixels.flatten == Seq.fill(6)("px"))
  }

  test("Map rows") {
    val pixelGrid = new PixelGrid(
      testingSeq
    )
    val mappedRows =
      pixelGrid.mapRows(_ => Seq.fill(2)("px"))
    assert(mappedRows.flatten == Seq.fill(6)("px"))
  }
}
