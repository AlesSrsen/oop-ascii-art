package helpers.stubs

import asciiApp.models.pixels.Pixel

case class StubPixel(value: Int) extends Pixel {}

object StubPixel {
  def min(): StubPixel = StubPixel(0)
  def max(): StubPixel = StubPixel(255)
  def corrected(value: Int): StubPixel =
    StubPixel(if (value < 0) 0 else if (value > 255) 255 else value)
}
