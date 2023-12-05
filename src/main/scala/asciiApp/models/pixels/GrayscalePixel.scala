package asciiApp.models.pixels

case class GrayscalePixel(_gray: Int) extends Pixel {
  val gray: Int = {
    if (_gray < 0) 0
    else if (_gray > 255) 255
    else _gray
  }
}

object GrayscalePixel {
  def min() = new GrayscalePixel(0)
  def max() = new GrayscalePixel(255)
}
