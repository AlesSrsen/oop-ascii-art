package models.image
import models.pixels.AsciiPixel

class AsciiImage(override protected val _pixels: Seq[Seq[AsciiPixel]])
    extends Image[AsciiPixel] {
  override def updated(row: Int, col: Int, pixel: AsciiPixel): AsciiImage = {
    val newPixels = _pixels.updated(row, _pixels(row).updated(col, pixel))
    new AsciiImage(newPixels)
  }
}
