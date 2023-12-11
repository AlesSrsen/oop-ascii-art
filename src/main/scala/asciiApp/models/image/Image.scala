package asciiApp.models.image

import asciiApp.models.grid.PixelGrid
import asciiApp.models.pixels.Pixel

/**
 * An image represented by a grid of pixels.
 * @param pixels Grid of pixels
 * @tparam T Type of pixels
 */
class Image[T <: Pixel](val pixels: PixelGrid[T]) {
  def height: Int = pixels.height
  def width: Int = pixels.width

  /**
   * Returns a pixel at a given position.
   * @param row Row of the pixel
   * @param col Column of the pixel
   * @return Pixel at the given position
   */
  def apply(row: Int, col: Int): T = pixels(row, col)
}
