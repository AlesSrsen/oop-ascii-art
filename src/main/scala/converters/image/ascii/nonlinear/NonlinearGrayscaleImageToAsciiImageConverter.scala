package converters.image.ascii.nonlinear

import converters.image.ImageToImageConverter
import models.image.{AsciiImage, GrayscaleImage}
import models.pixels.AsciiPixel

import scala.annotation.tailrec
import scala.collection.SortedMap

trait NonlinearGrayscaleImageToAsciiImageConverter
    extends ImageToImageConverter[GrayscaleImage, AsciiImage] {
  // Mapping of values is described by this map
  // Key is the smallest value from which the corresponding character is used
  // Character is used for values greater than or equal to the key
  // If no key was specified for a value, an exception is thrown
  def characterMapping: SortedMap[Int, Char]

  require(characterMapping.nonEmpty, "Character mapping must not be empty")

  def convert(grayscaleImage: GrayscaleImage): AsciiImage = {
    def sortedKeyValues = characterMapping.toSeq

    val asciiPixels = grayscaleImage.mapRows(_.map(grayscalePixel => {
      val value = grayscalePixel.gray
      val key = findLargestSmallerEqualKeyForValue(value, sortedKeyValues)
      val character = characterMapping(key)
      AsciiPixel(character)
    }))

    new AsciiImage(asciiPixels)
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
