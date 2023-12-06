package loaders.image.file

import asciiApp.models.pixels.RGBPixel
import converters.image.rgb.BufferedImageToRGBImageConverter
import helpers.TestWithFiles
import org.scalatest.Matchers.{be, convertToAnyShouldWrapper}
import org.scalatest.{BeforeAndAfter, FunSuite}

class RGBImageFileLoaderTestWith
    extends FunSuite
    with BeforeAndAfter
    with TestWithFiles {
  var bufferedImageToRGBImageConverter: BufferedImageToRGBImageConverter = _

  before {
    bufferedImageToRGBImageConverter = new BufferedImageToRGBImageConverter()
  }

  test("Load Image[RGBPixel] from file") {
    val image =
      new RGBImageFileLoader(
        getImageFromResources("testing_grid_image.png"),
        bufferedImageToRGBImageConverter).load()

    image.width should be(5)
    image.height should be(2)

    image(0, 0) should be(new RGBPixel(0, 0, 0))
    image(0, 1) should be(new RGBPixel(255, 0, 0))
    image(0, 2) should be(new RGBPixel(0, 255, 0))
    image(0, 3) should be(new RGBPixel(0, 0, 255))
    image(0, 4) should be(new RGBPixel(255, 255, 255))
    image(1, 0) should be(new RGBPixel(255, 255, 0))
    image(1, 1) should be(new RGBPixel(255, 0, 255))
    image(1, 2) should be(new RGBPixel(0, 255, 255))
    image(1, 3) should be(new RGBPixel(100, 100, 100))
    image(1, 4) should be(new RGBPixel(255, 255, 255))
  }

  test("Try to load not existing file") {
    assertThrows[IllegalArgumentException] {
      new RGBImageFileLoader(
        getRandomNonExistingTempFile(),
        bufferedImageToRGBImageConverter).load()
    }
  }

  test("Try to load file with wrong extension") {
    val tempFile = getRandomExistingTempFile(".image")
    assertThrows[IllegalArgumentException] {
      new RGBImageFileLoader(tempFile, bufferedImageToRGBImageConverter).load()
    }
    deleteFile(tempFile)
  }
}
