package asciiApp.models.pixels

case class AsciiPixel(symbol: Char) extends Pixel {
  def getString: String = symbol.toString
}
