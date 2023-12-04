package models.image
import models.pixels.GrayscalePixel

class GrayscaleImage(override protected val _pixels: Seq[Seq[GrayscalePixel]])
    extends Image[GrayscalePixel] {
  override def updated(
    row: Int,
    col: Int,
    pixel: GrayscalePixel): Image[GrayscalePixel] = {
    val newPixels = _pixels.updated(row, _pixels(row).updated(col, pixel))
    new GrayscaleImage(newPixels)
  }
}
