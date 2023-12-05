package converters.image.ascii.nonlinear

import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter

import scala.annotation.tailrec
import scala.collection.SortedMap

trait NonlinearGrayscaleImageToAsciiImageConverter
    extends ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]] {
  // Mapping of values is described by this map
  // Key is the smallest value from which the corresponding character is used
  // Character is used for values greater than or equal to the key
  // If no key was specified for a value, an exception is thrown
  def characterMapping: SortedMap[Int, Char]

  require(characterMapping.nonEmpty, "Character mapping must not be empty")

  def convert(grayscaleImage: Image[GrayscalePixel]): Image[AsciiPixel] = {
    def sortedKeyValues = characterMapping.toSeq

    val asciiPixels =
      grayscaleImage.pixels.mapRowsGrid(_.map(grayscalePixel => {
        val value = grayscalePixel.gray
        val key = findLargestSmallerEqualKeyForValue(value, sortedKeyValues)
        val character = characterMapping(key)
        AsciiPixel(character)
      }))

    new Image(asciiPixels)
  }

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
