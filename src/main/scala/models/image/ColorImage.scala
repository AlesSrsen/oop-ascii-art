package models.image
import models.grid.PixelGrid
import models.pixels.ColorPixel

abstract class ColorImage[T <: ColorPixel](pixels: PixelGrid[T])
    extends Image[T](pixels) {}
