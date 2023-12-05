package filters.image.gray

import asciiApp.models.pixels.GrayscalePixel
import helpers.TestWithImages
import org.scalatest.FunSuite

class BrightnessGrayscaleImageFilterTest extends FunSuite with TestWithImages {
  test("Check add brightness on square with edge values") {
    val image = createImage(
      Seq(
        Seq(new GrayscalePixel(0), new GrayscalePixel(255)),
      )
    )
    val brightenedImage =
      new BrightnessGrayscaleImageFilter(10).applyFilter(image)
    assert(brightenedImage.pixels(0, 0).gray == 10)
    assert(brightenedImage.pixels(0, 1).gray == 255)
  }

  test("Check subtract brightness on square with edge values") {
    val image = createImage(
      Seq(
        Seq(new GrayscalePixel(0), new GrayscalePixel(255)),
      )
    )
    val brightenedImage =
      new BrightnessGrayscaleImageFilter(-10).applyFilter(image)
    assert(brightenedImage.pixels(0, 0).gray == 0)
    assert(brightenedImage.pixels(0, 1).gray == 245)
  }

  test("Check add brightness on a rectangle image with middle values") {
    val image = createImage(
      Seq(
        Seq(
          new GrayscalePixel(0),
          new GrayscalePixel(255),
          new GrayscalePixel(100)
        ),
        Seq(
          new GrayscalePixel(255),
          new GrayscalePixel(0),
          new GrayscalePixel(100)
        )
      )
    )
    val brightenedImage =
      new BrightnessGrayscaleImageFilter(10).applyFilter(image)
    assert(brightenedImage.pixels(0, 0).gray == 10)
    assert(brightenedImage.pixels(0, 1).gray == 255)
    assert(brightenedImage.pixels(0, 2).gray == 110)
    assert(brightenedImage.pixels(1, 0).gray == 255)
    assert(brightenedImage.pixels(1, 1).gray == 10)
    assert(brightenedImage.pixels(1, 2).gray == 110)
  }

  test("Check subtract brightness on a rectangle image with middle values") {
    val image = createImage(
      Seq(
        Seq(
          new GrayscalePixel(0),
          new GrayscalePixel(255),
          new GrayscalePixel(100)
        ),
        Seq(
          new GrayscalePixel(255),
          new GrayscalePixel(0),
          new GrayscalePixel(100)
        )
      )
    )
    val brightenedImage =
      new BrightnessGrayscaleImageFilter(-10).applyFilter(image)
    assert(brightenedImage.pixels(0, 0).gray == 0)
    assert(brightenedImage.pixels(0, 1).gray == 245)
    assert(brightenedImage.pixels(0, 2).gray == 90)
    assert(brightenedImage.pixels(1, 0).gray == 245)
    assert(brightenedImage.pixels(1, 1).gray == 0)
    assert(brightenedImage.pixels(1, 2).gray == 90)
  }

  test("Add invalid brightness amount") {
    assertThrows[IllegalArgumentException] {
      new BrightnessGrayscaleImageFilter(256)
    }
  }

  test("Subtract invalid brightness amount") {
    assertThrows[IllegalArgumentException] {
      new BrightnessGrayscaleImageFilter(-256)
    }
  }

  test("Add edge brightness amount") {
    val image = createImage(
      Seq(
        Seq(
          new GrayscalePixel(0),
          new GrayscalePixel(100),
          new GrayscalePixel(255)
        )
      )
    )
    val brightenedImage =
      new BrightnessGrayscaleImageFilter(255).applyFilter(image)
    assert(brightenedImage.pixels(0, 0).gray == 255)
    assert(brightenedImage.pixels(0, 1).gray == 255)
    assert(brightenedImage.pixels(0, 2).gray == 255)
  }

  test("Subtract edge brightness amount") {
    val image = createImage(
      Seq(
        Seq(
          new GrayscalePixel(0),
          new GrayscalePixel(100),
          new GrayscalePixel(255)
        )
      )
    )
    val brightenedImage =
      new BrightnessGrayscaleImageFilter(-255).applyFilter(image)
    assert(brightenedImage.pixels(0, 0).gray == 0)
    assert(brightenedImage.pixels(0, 1).gray == 0)
    assert(brightenedImage.pixels(0, 2).gray == 0)
  }
}
