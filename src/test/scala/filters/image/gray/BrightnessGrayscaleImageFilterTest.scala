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

    compareImagePixels(
      brightenedImage,
      createImage(
        Seq(
          Seq(new GrayscalePixel(10), new GrayscalePixel(255)),
        )
      )
    )
  }

  test("Check subtract brightness on square with edge values") {
    val image = createImage(
      Seq(
        Seq(new GrayscalePixel(0), new GrayscalePixel(255)),
      )
    )
    val brightenedImage =
      new BrightnessGrayscaleImageFilter(-10).applyFilter(image)

    compareImagePixels(
      brightenedImage,
      createImage(
        Seq(
          Seq(new GrayscalePixel(0), new GrayscalePixel(245)),
        )
      )
    )
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

    compareImagePixels(
      brightenedImage,
      createImage(
        Seq(
          Seq(
            new GrayscalePixel(10),
            new GrayscalePixel(255),
            new GrayscalePixel(110)
          ),
          Seq(
            new GrayscalePixel(255),
            new GrayscalePixel(10),
            new GrayscalePixel(110)
          )
        )
      )
    )
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

    compareImagePixels(
      brightenedImage,
      createImage(
        Seq(
          Seq(
            new GrayscalePixel(0),
            new GrayscalePixel(245),
            new GrayscalePixel(90)
          ),
          Seq(
            new GrayscalePixel(245),
            new GrayscalePixel(0),
            new GrayscalePixel(90)
          )
        )
      )
    )
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
    compareImagePixels(
      brightenedImage,
      createImage(
        Seq(
          Seq(
            new GrayscalePixel(255),
            new GrayscalePixel(255),
            new GrayscalePixel(255)
          )
        )
      )
    )
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

    compareImagePixels(
      brightenedImage,
      createImage(
        Seq(
          Seq(
            new GrayscalePixel(0),
            new GrayscalePixel(0),
            new GrayscalePixel(0)
          )
        )
      )
    )
  }
}
