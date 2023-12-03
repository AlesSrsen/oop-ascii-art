package operators

import models.pixels.GrayscalePixel

class GrayscalePixelOperator extends PixelOperator[GrayscalePixel] {
  override def min(): GrayscalePixel = GrayscalePixel.min()

  override def max(): GrayscalePixel = GrayscalePixel.max()

  override def average(a: GrayscalePixel, b: GrayscalePixel): GrayscalePixel =
    new GrayscalePixel((a.gray + b.gray) / 2)

  override def add(a: GrayscalePixel, b: GrayscalePixel): GrayscalePixel =
    new GrayscalePixel(a.gray + b.gray)

  override def subtract(a: GrayscalePixel, b: GrayscalePixel): GrayscalePixel =
    new GrayscalePixel(a.gray - b.gray)

  override def inverse(a: GrayscalePixel): GrayscalePixel =
    new GrayscalePixel(max().gray - a.gray)

  override def addScalar(a: GrayscalePixel, b: Int): GrayscalePixel =
    new GrayscalePixel(a.gray + b)
}
