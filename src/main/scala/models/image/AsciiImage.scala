package models.image
import models.grid.PixelGrid
import models.pixels.AsciiPixel

class AsciiImage(pixels: PixelGrid[AsciiPixel])
    extends Image[AsciiPixel](pixels) {
}
