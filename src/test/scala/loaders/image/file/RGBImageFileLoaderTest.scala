package loaders.image.file

import asciiApp.models.pixels.RGBPixel
import helpers.{TestWithFiles, TestWithImages}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{be, convertToAnyShouldWrapper}

class RGBImageFileLoaderTest
    extends FunSuite
    with TestWithFiles
    with TestWithImages {
  test("Load Image[RGBPixel] from file") {
    val image =
      new RGBImageFileLoader(getImageFromResources("testing_grid_image.png"))
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
      new RGBImageFileLoader(getRandomNonExistingTempFile()).load()
    }
  }

  test("Try to load file with wrong extension") {
    val tempFile = getRandomExistingTempFile(".image")
    assertThrows[IllegalArgumentException] {
      new RGBImageFileLoader(tempFile).load()
    }
    deleteFile(tempFile)
  }
}
