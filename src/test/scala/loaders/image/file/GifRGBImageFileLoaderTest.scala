package loaders.image.file

import asciiApp.models.pixels.RGBPixel
import helpers.{TestWithFiles, TestWithImages}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{be, convertToAnyShouldWrapper}

class GifRGBImageFileLoaderTest
    extends FunSuite
    with TestWithFiles
    with TestWithImages {
  test("Load Image[RGBPixel] from gif file") {
    val image =
      new GifRGBImageFileLoader(getImageFromResources("testing_grid_image.gif"))
        .load()

    image.width should be(5)
    image.height should be(2)

    compareImagePixels(
      image,
      createImage(
        Seq(
          Seq(
            new RGBPixel(0, 0, 0),
            new RGBPixel(255, 0, 0),
            new RGBPixel(0, 255, 0),
            new RGBPixel(0, 0, 255),
            new RGBPixel(255, 255, 255)
          ),
          Seq(
            new RGBPixel(255, 255, 0),
            new RGBPixel(255, 0, 255),
            new RGBPixel(0, 255, 255),
            new RGBPixel(100, 100, 100),
            new RGBPixel(255, 255, 255)
          )
        )
      )
    )
  }

  test("Try to load not existing file") {
    assertThrows[IllegalArgumentException] {
      new GifRGBImageFileLoader(getRandomNonExistingTempFile()).load()
    }
  }

  test("Try to load file with wrong extension") {
    val tempFile = getRandomExistingTempFile(".image")
    assertThrows[IllegalArgumentException] {
      new GifRGBImageFileLoader(tempFile).load()
    }
    deleteFile(tempFile)
  }
}
