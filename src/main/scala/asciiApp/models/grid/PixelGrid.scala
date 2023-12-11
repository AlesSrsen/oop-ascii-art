package asciiApp.models.grid

import asciiApp.models.pixels.Pixel

/**
 * A grid of pixels.
 * @param pixels Grid of pixels
 * @tparam T Type of pixels
 */
class PixelGrid[T <: Pixel](private val pixels: Seq[Seq[T]]) {
  require(
    pixels.nonEmpty
      && pixels.head.nonEmpty
      && pixels
        .forall(
          _.length == pixels.head.length
        )
  )

  /**
   * Returns the height of the grid.
   * @return Height of the grid
   */
  def height: Int = pixels.size

  /**
   * Returns the width of the grid.
   * @return Width of the grid
   */
  def width: Int = pixels.head.size

  /**
   * Returns a sequence of pixels.
   * @return Sequence of pixels
   */
  def getPixelSeq: Seq[Seq[T]] = pixels

  /**
   * Returns a reversed sequence of pixels.
   * @return
   */
  def reverse(): Seq[Seq[T]] = getPixelSeq.reverse

  /**
   * Returns a reversed grid of pixels.
   * @return Reversed grid of pixels
   */
  def reversedGrid(): PixelGrid[T] = new PixelGrid(pixels.reverse)

  /**
   * Mapping of the pixels to another PixelGrid
   * @param f Mapping function
   * @tparam O Type of the new pixels
   * @return New PixelGrid
   */
  def mapPixelsGrid[O <: Pixel](f: T => O): PixelGrid[O] =
    new PixelGrid(mapPixels(f))

  /**
   * Mapping of the rows to another PixelGrid
   * @param f Mapping function
   * @tparam O Type of the new pixels
   * @return New PixelGrid
   */
  def mapRowsGrid[O <: Pixel](f: Seq[T] => Seq[O]): PixelGrid[O] =
    new PixelGrid(mapRows(f))

  /**
   * Mapping of the pixels to another sequence
   * @param f Mapping function
   * @tparam O Type of the result
   * @return New sequence
   */
  def mapPixels[O](f: T => O): Seq[Seq[O]] =
    mapRows(_.map(f))

  /**
   * Mapping of the rows to another sequence
   * @param f Mapping function
   * @tparam O Type of the result
   * @return New sequence
   */
  def mapRows[O](f: Seq[T] => Seq[O]): Seq[Seq[O]] =
    pixels.map(f)

  /**
   * Returns a pixel at given position.
   * @param row Row of the pixel
   * @param col Column of the pixel
   * @return Pixel at given position
   */
  def apply(row: Int, col: Int): T = pixels(row)(col)
}
