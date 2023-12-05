package models.image

import models.grid.PixelGrid
import models.pixels.Pixel

abstract class Image[T <: Pixel](val pixels: PixelGrid[T]) {
  def height: Int = pixels.height
  def width: Int = pixels.width
  def apply(row: Int, col: Int): T = pixels(row, col)
}
