package filters.image.generic

import helpers.TestWithImages
import helpers.stubs.{StubPixel, StubPixelOperator}
import org.scalatest.FunSuite

class InvertImageFilterTest extends FunSuite with TestWithImages {
  val invertImageFilter = new InvertImageFilter(new StubPixelOperator)

  test("Check inversion on square image with edge values") {
    val image = createImage(
      Seq(
        Seq(new StubPixel(0), new StubPixel(255)),
        Seq(new StubPixel(255), new StubPixel(0))
      )
    )

    val invertedImage = invertImageFilter.applyFilter(image)

    compareImagePixels(
      invertedImage,
      createImage(
        Seq(
          Seq(new StubPixel(255), new StubPixel(0)),
          Seq(new StubPixel(0), new StubPixel(255))
        )
      )
    )
  }

  test("Check inversion on a rectangle image with middle values") {
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

    val invertedImage = invertImageFilter.applyFilter(image)

    compareImagePixels(
      invertedImage,
      createImage(
        Seq(
          Seq(
            new StubPixel(255),
            new StubPixel(0),
            new StubPixel(155)
          ),
          Seq(
            new StubPixel(0),
            new StubPixel(255),
            new StubPixel(155)
          )
        )
      )
    )
  }
}
