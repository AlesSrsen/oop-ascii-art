package asciiApp.models.pixels

case class GrayscalePixel(gray: Int) extends Pixel {
  require(gray >= 0 && gray <= 255, "Grayscale value must be between 0 and 255")
}

object GrayscalePixel {
  def min() = new GrayscalePixel(0)
  def max() = new GrayscalePixel(255)

  def corrected(gray: Int): GrayscalePixel =
    new GrayscalePixel(correctValue(gray))

  private def correctValue(value: Int): Int =
    if (value < 0) 0
    else if (value > 255) 255
    else value
}
