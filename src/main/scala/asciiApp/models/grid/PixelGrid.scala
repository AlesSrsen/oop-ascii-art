package asciiApp.models.grid

import asciiApp.models.pixels.Pixel

class PixelGrid[T <: Pixel](private val pixels: Seq[Seq[T]]) {
  require(
    pixels.nonEmpty
      && pixels.head.nonEmpty
      && pixels
        .forall(
          _.length == pixels.head.length
        )
  )

  def height: Int = pixels.size
  def width: Int = pixels.head.size

  def getPixelSeq: Seq[Seq[T]] = pixels

  def reverse(): Seq[Seq[T]] = getPixelSeq.reverse

  def reversedGrid(): PixelGrid[T] = new PixelGrid(pixels.reverse)

  def mapPixelsGrid[O <: Pixel](f: T => O): PixelGrid[O] =
    new PixelGrid(mapPixels(f))

  def mapRowsGrid[O <: Pixel](f: Seq[T] => Seq[O]): PixelGrid[O] =
    new PixelGrid(mapRows(f))

  def mapPixels[O](f: T => O): Seq[Seq[O]] =
    mapRows(_.map(f))

  def mapRows[O](f: Seq[T] => Seq[O]): Seq[Seq[O]] =
    pixels.map(f)

  def apply(row: Int, col: Int): T = pixels(row)(col)
}
