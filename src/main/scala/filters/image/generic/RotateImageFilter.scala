package filters.image.generic

import asciiApp.models.grid.PixelGrid
import asciiApp.models.image.Image
import asciiApp.models.pixels.Pixel
import filters.image.ImageFilter

import scala.math.abs

/**
 * RotateImageFilter rotates an Image by a given amount.
 * Positive values rotate clockwise, negative values rotate counterclockwise.
 * @param amount the amount of rotation to be applied. Must be a multiple of 90.
 * @tparam T the type of Pixel.
 */
class RotateImageFilter[T <: Pixel](amount: Int) extends ImageFilter[Image[T]] {
  require(abs(amount) % 90 == 0)

  /**
   * Applies the filter on the given item.
   *
   * @param item the item to be filtered.
   * @return the filtered item.
   */
  override def applyFilter(item: Image[T]): Image[T] = {
    var newImage: Image[T] = item
    val div = abs(amount) / 90
    val count = if (amount <= 0) div % 4 else 4 - div % 4
    for (i <- 0 until count)
      newImage = rotateCounterclockwise(newImage)

    newImage
  }

  private def rotateCounterclockwise(item: Image[T]): Image[T] = {
    val rotatedPixels = item.pixels.getPixelSeq.map(_.reverse).transpose
    new Image(new PixelGrid[T](rotatedPixels))
  }
}
