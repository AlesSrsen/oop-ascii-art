package helpers

import asciiApp.models.grid.PixelGrid
import asciiApp.models.image.Image
import asciiApp.models.pixels.Pixel

trait TestWithImages {
  def createImage[T <: Pixel](pixels: Seq[Seq[T]]) =
    new Image[T](new PixelGrid(pixels))
}
