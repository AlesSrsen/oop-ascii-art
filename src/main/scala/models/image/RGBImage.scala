package models.image

import models.pixels.RGBPixel

class RGBImage(override val pixels: Iterable[Iterable[RGBPixel]])
    extends ColorImage[RGBPixel] {}
