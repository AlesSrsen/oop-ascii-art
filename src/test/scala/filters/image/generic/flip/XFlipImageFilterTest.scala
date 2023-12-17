package filters.image.generic.flip

import helpers.TestWithImages
import helpers.stubs.StubPixel
import org.scalatest.FunSuite

class XFlipImageFilterTest extends FunSuite with TestWithImages {
  test("Check flip on square image") {
    val image = createImage(
      Vector(
        Vector(new StubPixel(0), new StubPixel(100)),
        Vector(new StubPixel(200), new StubPixel(250))
      )
    )

    val flippedImage = new XFlipImageFilter().applyFilter(image)

    compareImagePixels(
      flippedImage,
      createImage(
        Vector(
          Vector(new StubPixel(200), new StubPixel(250)),
          Vector(new StubPixel(0), new StubPixel(100))
        )
      )
    )
  }

  test("Check flip on a rectangle image") {
    val image = createImage(
      Vector(
        Vector(
          new StubPixel(0),
          new StubPixel(10),
          new StubPixel(20)
        ),
        Vector(
          new StubPixel(30),
          new StubPixel(40),
          new StubPixel(50)
        )
      )
    )

    val flippedImage = new XFlipImageFilter().applyFilter(image)

    compareImagePixels(
      flippedImage,
      createImage(
        Vector(
          Vector(
            new StubPixel(30),
            new StubPixel(40),
            new StubPixel(50)
          ),
          Vector(
            new StubPixel(0),
            new StubPixel(10),
            new StubPixel(20)
          )
        )
      )
    )
  }
}
