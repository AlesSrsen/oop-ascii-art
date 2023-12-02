package models.image

import models.pixels.Pixel

abstract class Image[T <: Pixel] {
  def pixels: Iterable[Iterable[T]]
  def getHeight: Int = pixels.size
  def getWidth: Int = pixels.head.size
}
