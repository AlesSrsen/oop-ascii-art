package asciiApp.models.image

import asciiApp.models.grid.PixelGrid
import asciiApp.models.pixels.Pixel

class Image[T <: Pixel](val pixels: PixelGrid[T]) {
  def height: Int = pixels.height
  def width: Int = pixels.width
  def apply(row: Int, col: Int): T = pixels(row, col)
}
