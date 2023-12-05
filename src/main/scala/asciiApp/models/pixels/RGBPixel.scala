package asciiApp.models.pixels

case class RGBPixel(_red: Int, _green: Int, _blue: Int) extends ColorPixel {
  val red: Int = correctValue(_red)
  val green: Int = correctValue(_green)
  val blue: Int = correctValue(_blue)
}

object RGBPixel {
  def min() = new RGBPixel(0, 0, 0)
  def max() = new RGBPixel(255, 255, 255)
}
