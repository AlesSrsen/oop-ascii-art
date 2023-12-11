package asciiApp.models.pixels

/**
 * Represents a grayscale pixel.
 * @param gray Value of gray color between 0 and 255
 */
case class GrayscalePixel(gray: Int) extends Pixel {
  require(gray >= 0 && gray <= 255, "Grayscale value must be between 0 and 255")
}

/**
 * Companion object for GrayscalePixel
 * Contains some useful methods
 */
object GrayscalePixel {

  /**
   * Returns a pixel with gray value set to minimum eg. 0
   * @return
   */
  def min() = new GrayscalePixel(0)

  /**
   * Returns a pixel with gray value set to maximum eg. 255
   * @return
   */
  def max() = new GrayscalePixel(255)

  /**
   * Returns a pixel with gray value corrected to be in range between 0 and 255
   * @param gray Gray color value
   * @return Corrected pixel
   */
  def corrected(gray: Int): GrayscalePixel =
    new GrayscalePixel(correctValue(gray))

  private def correctValue(value: Int): Int =
    if (value < 0) 0
    else if (value > 255) 255
    else value
}
