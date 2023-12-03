package models.image

import models.pixels.Pixel

abstract class Image[T <: Pixel] {
  require(
    _pixels.nonEmpty
      && _pixels.head.nonEmpty
      && _pixels
        .forall(
          _.length == _pixels.head.length
        )
  )
  protected def _pixels: Seq[Seq[T]]
  def height: Int = _pixels.size
  def width: Int = _pixels.head.size

  def pixels: Seq[Seq[T]] = _pixels

  def mapRows[O](f: Seq[T] => Seq[O]): Seq[Seq[O]] =
    _pixels.map(f)

  def mapPixels[O](f: T => O): Seq[Seq[O]] =
    mapRows(_.map(f))

  def apply(row: Int, col: Int): T = _pixels(row)(col)

  def updated(row: Int, col: Int, pixel: T): Image[T];
}
