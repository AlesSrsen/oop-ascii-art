package operators

import models.pixels.Pixel

trait PixelOperator[T <: Pixel] {
  def min(): T
  def max(): T
  def average(a: T, b: T): T
  def add(a: T, b: T): T
  def addScalar(a: T, b: Int): T
  def subtract(a: T, b: T): T
  def inverse(a: T): T
}
