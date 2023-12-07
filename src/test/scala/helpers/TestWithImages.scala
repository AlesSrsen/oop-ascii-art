package helpers

import asciiApp.models.grid.PixelGrid
import asciiApp.models.image.Image
import asciiApp.models.pixels.Pixel
import org.scalatest.FunSuite

trait TestWithImages extends FunSuite {
  def createImage[T <: Pixel](pixels: Seq[Seq[T]]) =
    new Image[T](new PixelGrid(pixels))

  def compareImagePixels[T <: Pixel](
    original: Image[T],
    expected: Image[T]): Unit =
    assert(original.pixels.getPixelSeq == expected.pixels.getPixelSeq)
}
