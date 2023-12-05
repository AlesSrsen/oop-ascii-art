package models.image
import models.grid.PixelGrid
import models.pixels.GrayscalePixel

class GrayscaleImage(pixels: PixelGrid[GrayscalePixel])
    extends Image[GrayscalePixel](pixels) {
}
