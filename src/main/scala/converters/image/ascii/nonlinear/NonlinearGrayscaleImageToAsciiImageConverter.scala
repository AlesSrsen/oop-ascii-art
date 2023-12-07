package converters.image.ascii.nonlinear

import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter

import scala.annotation.tailrec
import scala.collection.SortedMap

/**
 * Converts an Image[GrayscalePixel] to an Image[AsciiPixel]
 * Converts images based on a nonlinear mapping of values to characters
 */
trait NonlinearGrayscaleImageToAsciiImageConverter
    extends ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]] {

  /**
   * Mapping of values is described by this map
   * Key is the smallest value from which the corresponding character is used
   * Character is used for values greater than or equal to the key
   * If no key was specified for a value, an exception is thrown
   */
  val characterMapping: SortedMap[Int, Char]

  /**
   * Converts an Image[GrayscalePixel] to an Image[AsciiPixel]
   * @param grayscaleImage input
   *  @return converted output
   */
  def convert(grayscaleImage: Image[GrayscalePixel]): Image[AsciiPixel] = {
    require(characterMapping.nonEmpty, "Character mapping must not be empty")
    val sortedKeyValues = characterMapping.toIndexedSeq

    val asciiPixels =
      grayscaleImage.pixels.mapPixelsGrid(grayscalePixel => {
        val value = grayscalePixel.gray
        val key = findLargestSmallerEqualKeyForValue(value, sortedKeyValues)
        val character = characterMapping(key)
        AsciiPixel(character)
      })

    new Image(asciiPixels)
  }

  /**
   * Finds the largest key from the sorted key values that is smaller than or equal to the value
   * @param value value to find the largest key for
   * @param sortedKeyValues sorted key values
   * @return largest key from the sorted key values that is smaller than or equal to the value
   */
  private def findLargestSmallerEqualKeyForValue(
    value: Int,
    sortedKeyValues: Seq[(Int, Char)]): Int = {
    @tailrec
    def findLargestSmallerEqualKeyForValue(
      value: Int,
      sortedKeyValues: Seq[(Int, Char)],
      largestSmallerEqualKey: Int): Int =
      if (sortedKeyValues.isEmpty)
        largestSmallerEqualKey
      else {
        val (key, _) = sortedKeyValues.head
        if (key <= value)
          findLargestSmallerEqualKeyForValue(value, sortedKeyValues.tail, key)
        else
          largestSmallerEqualKey
      }

    findLargestSmallerEqualKeyForValue(
      value,
      sortedKeyValues,
      sortedKeyValues.head._1)
  }
}
