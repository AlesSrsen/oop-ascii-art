package models.image
import models.pixels.GrayscalePixel

class GrayscaleImage(override val pixels: Iterable[Iterable[GrayscalePixel]])
    extends Image[GrayscalePixel] {}
