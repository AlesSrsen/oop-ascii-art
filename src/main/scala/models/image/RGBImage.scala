package models.image

import models.grid.PixelGrid
import models.pixels.RGBPixel

class RGBImage(pixels: PixelGrid[RGBPixel])
    extends ColorImage[RGBPixel](pixels) {
}
