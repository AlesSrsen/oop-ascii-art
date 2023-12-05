package loaders.external.file

import helpers.TestWithFiles
import org.scalatest.FunSuite
import org.scalatest.Matchers.{be, convertToAnyShouldWrapper}

class BufferedImageFileLoaderTest extends FunSuite with TestWithFiles {
  test("Load Image[RGBPixel] from file") {
    val image =
      new BufferedImageFileLoader(getImage("testing_grid_image.png")).load()
    image.getWidth() should be(5)
    image.getHeight() should be(2)
  }

  test("Try to load not existing file") {
    assertThrows[IllegalArgumentException] {
      new BufferedImageFileLoader(getRandomNonExistingFile).load()
    }
  }
}
