package operators

import asciiApp.models.pixels.GrayscalePixel

class GrayscalePixelOperator extends PixelOperator[GrayscalePixel] {

  /**
   * Returns the minimum value of a GrayscalePixel
   * @return GrayscalePixel that represents minimum value
   */
  override def min(): GrayscalePixel = GrayscalePixel.min()

  /**
   * Returns the average value of two GrayscalePixels
   * @param a GrayscalePixel
   * @param b GrayscalePixel
   * @return GrayscalePixel that represents the average
   */
  override def average(a: GrayscalePixel, b: GrayscalePixel): GrayscalePixel =
    GrayscalePixel.corrected(((a.gray + b.gray) / 2) + (a.gray + b.gray) % 2)

  /**
   * Returns the sum of two GrayscalePixels
   * @param a GrayscalePixel
   * @param b GrayscalePixel
   * @return GrayscalePixel that represents the sum
   */
  override def add(a: GrayscalePixel, b: GrayscalePixel): GrayscalePixel =
    GrayscalePixel.corrected(a.gray + b.gray)

  /**
   * Returns the difference between two GrayscalePixels
   * @param a GrayscalePixel
   * @param b GrayscalePixel
   * @return GrayscalePixel that represents the difference
   */
  override def subtract(a: GrayscalePixel, b: GrayscalePixel): GrayscalePixel =
    GrayscalePixel.corrected(a.gray - b.gray)

  /**
   * Returns the inverse of a GrayscalePixel
   * @param a GrayscalePixel
   * @return GrayscalePixel that represents the inverse
   */
  override def inverse(a: GrayscalePixel): GrayscalePixel =
    GrayscalePixel.corrected(max().gray - a.gray)

  /**
   * Returns the maximum value of a GrayscalePixel
   * @return GrayscalePixel that represents maximum value
   */
  override def max(): GrayscalePixel = GrayscalePixel.max()

  /**
   * Returns the sum of a GrayscalePixel and a scalar
   * @param a GrayscalePixel
   * @param b Int scalar
   * @return GrayscalePixel that represents the sum
   */
  override def addScalar(a: GrayscalePixel, b: Int): GrayscalePixel =
    GrayscalePixel.corrected(a.gray + b)
}
