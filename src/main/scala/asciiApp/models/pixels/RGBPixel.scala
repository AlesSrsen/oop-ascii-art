package asciiApp.models.pixels

/**
 * Represents a pixel with RGB color values
 * @param red Value of red color between 0 and 255
 * @param green Value of green color between 0 and 255
 * @param blue Value of blue color between 0 and 255
 */
case class RGBPixel(red: Int, green: Int, blue: Int) extends ColorPixel {
  require(red >= 0 && red <= 255, "Red value must be between 0 and 255")
  require(green >= 0 && green <= 255, "Green value must be between 0 and 255")
  require(blue >= 0 && blue <= 255, "Blue value must be between 0 and 255")
}

/**
 * Companion object for RGBPixel
 * Contains some useful methods
 */
object RGBPixel {

  /**
   * Returns a pixel with all color values set to minimum eg. 0
   * @return
   */
  def min() = new RGBPixel(0, 0, 0)

  /**
   * Returns a pixel with all color values set to maximum eg. 255
   * @return
   */
  def max() = new RGBPixel(255, 255, 255)

  /**
   * Returns a pixel with all color values corrected to be in range between 0 and 255
   * @param red Red color value
   * @param green Green color value
   * @param blue Blue color value
   * @return Corrected pixel
   */
  def corrected(red: Int, green: Int, blue: Int): RGBPixel =
    new RGBPixel(correctValue(red), correctValue(green), correctValue(blue))

  private def correctValue(value: Int): Int =
    if (value < 0) 0
    else if (value > 255) 255
    else value
}
