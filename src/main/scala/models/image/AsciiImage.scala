package models.image
import models.pixels.AsciiPixel

class AsciiImage(override val pixels: Iterable[Iterable[AsciiPixel]])
    extends Image[AsciiPixel] {}
