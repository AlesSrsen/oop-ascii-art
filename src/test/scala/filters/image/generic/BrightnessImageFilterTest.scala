package filters.image.generic

import helpers.TestWithImages
import helpers.stubs.{StubPixel, StubPixelOperator}
import org.scalatest.FunSuite

class BrightnessImageFilterTest extends FunSuite with TestWithImages {
  val stubPixelOperator = new StubPixelOperator()

  test("Check add brightness on square with edge values") {
    val image = createImage(
      Seq(
        Seq(new StubPixel(0), new StubPixel(255)),
      )
    )
    val brightenedImage =
      new BrightnessImageFilter(10, stubPixelOperator).applyFilter(image)

    compareImagePixels(
      brightenedImage,
      createImage(
        Seq(
          Seq(new StubPixel(10), new StubPixel(255)),
        )
      )
    )
  }

  test("Check subtract brightness on square with edge values") {
    val image = createImage(
      Seq(
        Seq(new StubPixel(0), new StubPixel(255)),
      )
    )
    val brightenedImage =
      new BrightnessImageFilter(-10, stubPixelOperator).applyFilter(image)

    compareImagePixels(
      brightenedImage,
      createImage(
        Seq(
          Seq(new StubPixel(0), new StubPixel(245)),
        )
      )
    )
  }

  test("Check add brightness on a rectangle image with middle values") {
    val image = createImage(
      Seq(
        Seq(
          new StubPixel(0),
          new StubPixel(255),
          new StubPixel(100)
        ),
        Seq(
          new StubPixel(255),
          new StubPixel(0),
          new StubPixel(100)
        )
      )
    )
    val brightenedImage =
      new BrightnessImageFilter(10, stubPixelOperator).applyFilter(image)

    compareImagePixels(
      brightenedImage,
      createImage(
        Seq(
          Seq(
            new StubPixel(10),
            new StubPixel(255),
            new StubPixel(110)
          ),
          Seq(
            new StubPixel(255),
            new StubPixel(10),
            new StubPixel(110)
          )
        )
      )
    )
  }

  test("Check subtract brightness on a rectangle image with middle values") {
    val image = createImage(
      Seq(
        Seq(
          new StubPixel(0),
          new StubPixel(255),
          new StubPixel(100)
        ),
        Seq(
          new StubPixel(255),
          new StubPixel(0),
          new StubPixel(100)
        )
      )
    )
    val brightenedImage =
      new BrightnessImageFilter(-10, stubPixelOperator).applyFilter(image)

    compareImagePixels(
      brightenedImage,
      createImage(
        Seq(
          Seq(
            new StubPixel(0),
            new StubPixel(245),
            new StubPixel(90)
          ),
          Seq(
            new StubPixel(245),
            new StubPixel(0),
            new StubPixel(90)
          )
        )
      )
    )
  }
}
