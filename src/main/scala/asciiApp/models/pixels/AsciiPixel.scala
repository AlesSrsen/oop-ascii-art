package asciiApp.models.pixels

/**
 * A pixel that can be represented by a single character.
 * @param symbol Character that represents the pixel
 */
case class AsciiPixel(symbol: Char) extends Pixel {

  /**
   * Returns a string representation of the pixel.
   * @return String representation of the pixel
   */
  def getString: String = symbol.toString
}
