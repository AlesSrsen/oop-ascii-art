package operators

import asciiApp.models.pixels.Pixel

/**
 * Trait that defines the operations that can be performed on a Pixel
 * @tparam T Pixel
 */
trait PixelOperator[T <: Pixel] {

  /**
   * Returns the minimum value of a Pixel
   * @return Pixel that represents minimum value
   */
  def min(): T

  /**
   * Returns the maximum value of a Pixel
   * @return Pixel that represents maximum value
   */
  def max(): T

  /**
   * Returns the average value of two Pixels
   * @param a Pixel
   * @param b Pixel
   * @return Pixel that represents the average
   */
  def average(a: T, b: T): T

  /**
   * Returns the sum of two Pixels
   * @param a Pixel
   * @param b Pixel
   * @return Pixel that represents the sum
   */
  def add(a: T, b: T): T

  /**
   * Returns the difference between two Pixels
   * @param a Pixel
   * @param b Pixel
   * @return Pixel that represents the difference
   */
  def addScalar(a: T, b: Int): T

  /**
   * Returns the difference between two Pixels
   * @param a Pixel
   * @param b Pixel
   * @return Pixel that represents the difference
   */
  def subtract(a: T, b: T): T

  /**
   * Returns the inverse of a Pixel
   * @param a Pixel
   * @return Pixel that represents the inverse
   */
  def inverse(a: T): T
}
