package models.image

import models.pixels.RGBPixel

class RGBImage(override protected val _pixels: Seq[Seq[RGBPixel]])
    extends ColorImage[RGBPixel] {
  override def updated(row: Int, col: Int, pixel: RGBPixel): Image[RGBPixel] = {
    val newPixels = _pixels.updated(row, _pixels(row).updated(col, pixel))
    new RGBImage(newPixels)
  }
}
