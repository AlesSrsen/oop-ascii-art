package helpers.stubs

import operators.PixelOperator

class StubPixelOperator extends PixelOperator[StubPixel] {

  /**
   * Returns the minimum value of a Pixel
   *
   * @return Pixel that represents minimum value
   */
  override def min(): StubPixel = StubPixel.min()

  /**
   * Returns the maximum value of a Pixel
   *
   * @return Pixel that represents maximum value
   */
  override def max(): StubPixel = StubPixel.max()

  /**
   * Returns the average value of two Pixels
   *
   * @param a Pixel
   * @param b Pixel
   * @return Pixel that represents the average
   */
  override def average(a: StubPixel, b: StubPixel): StubPixel =
    StubPixel.corrected(((a.value + b.value) / 2) + ((a.value + b.value) % 2))

  /**
   * Returns the sum of two Pixels
   *
   * @param a Pixel
   * @param b Pixel
   * @return Pixel that represents the sum
   */
  override def add(a: StubPixel, b: StubPixel): StubPixel =
    StubPixel.corrected(a.value + b.value)

  /**
   * Returns the difference between two Pixels
   *
   * @param a Pixel
   * @param b Pixel
   * @return Pixel that represents the difference
   */
  override def addScalar(a: StubPixel, b: Int): StubPixel =
    StubPixel.corrected(a.value + b)

  /**
   * Returns the difference between two Pixels
   *
   * @param a Pixel
   * @param b Pixel
   * @return Pixel that represents the difference
   */
  override def subtract(a: StubPixel, b: StubPixel): StubPixel =
    StubPixel.corrected(a.value - b.value)

  /**
   * Returns the inverse of a Pixel
   *
   * @param a Pixel
   * @return Pixel that represents the inverse
   */
  override def inverse(a: StubPixel): StubPixel =
    StubPixel.corrected(max().value - a.value)
}
