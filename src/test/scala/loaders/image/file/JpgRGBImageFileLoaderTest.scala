package loaders.image.file

import asciiApp.models.pixels.RGBPixel
import helpers.{TestWithFiles, TestWithImages}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{be, convertToAnyShouldWrapper}

class JpgRGBImageFileLoaderTest
    extends FunSuite
    with TestWithFiles
    with TestWithImages {
  test("Load Image[RGBPixel] from jpg file") {
    val image =
      new JpgRGBImageFileLoader(getImageFromResources("testing_grid_image.jpg"))
        .load()

    image.width should be(5)
    image.height should be(2)

    // I was unable to create a jpg image with the same colors as other test images
    compareImagePixels(
      image,
      createImage(
        Seq(
          Seq(
            new RGBPixel(1, 0, 0),
            new RGBPixel(255, 1, 1),
            new RGBPixel(0, 255, 1),
            new RGBPixel(0, 0, 254),
            new RGBPixel(255, 255, 255)
          ),
          Seq(
            new RGBPixel(255, 255, 0),
            new RGBPixel(255, 0, 254),
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
      new JpgRGBImageFileLoader(getRandomNonExistingTempFile()).load()
    }
  }

  test("Try to load file with wrong extension") {
    val tempFile = getRandomExistingTempFile(".image")
    assertThrows[IllegalArgumentException] {
      new JpgRGBImageFileLoader(tempFile).load()
    }
    deleteFile(tempFile)
  }
}
