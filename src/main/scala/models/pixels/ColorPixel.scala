package models.pixels

abstract class ColorPixel extends Pixel {
  protected def correctValue(value: Int): Int =
    if (value < 0) 0
    else if (value > 255) 255
    else value
}
