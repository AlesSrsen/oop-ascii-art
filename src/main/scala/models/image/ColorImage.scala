package models.image
import models.pixels.ColorPixel

abstract class ColorImage[T <: ColorPixel] extends Image[T] {
}
