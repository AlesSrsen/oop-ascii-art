package asciiApp.models.pixels

case class RGBPixel(red: Int, green: Int, blue: Int) extends ColorPixel {
  require(red >= 0 && red <= 255, "Red value must be between 0 and 255")
  require(green >= 0 && green <= 255, "Green value must be between 0 and 255")
  require(blue >= 0 && blue <= 255, "Blue value must be between 0 and 255")
}

object RGBPixel {
  def min() = new RGBPixel(0, 0, 0)
  def max() = new RGBPixel(255, 255, 255)
  def corrected(red: Int, green: Int, blue: Int): RGBPixel =
    new RGBPixel(correctValue(red), correctValue(green), correctValue(blue))

  private def correctValue(value: Int): Int =
    if (value < 0) 0
    else if (value > 255) 255
    else value
}
