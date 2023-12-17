package filters.image.generic.flip

import helpers.TestWithImages
import helpers.stubs.StubPixel
import org.scalatest.FunSuite

class YFlipImageFilterTest extends FunSuite with TestWithImages {
  test("Check flip on square image") {
    val image = createImage(
      Seq(
        Seq(new StubPixel(0), new StubPixel(100)),
        Seq(new StubPixel(200), new StubPixel(250))
      )
    )

    val flippedImage = new YFlipImageFilter().applyFilter(image)

    compareImagePixels(
      flippedImage,
      createImage(
        Seq(
          Seq(new StubPixel(100), new StubPixel(0)),
          Seq(new StubPixel(250), new StubPixel(200))
        )
      )
    )
  }

  test("Check flip on a rectangle image") {
    val image = createImage(
      Seq(
        Seq(
          new StubPixel(0),
          new StubPixel(10),
          new StubPixel(20)
        ),
        Seq(
          new StubPixel(30),
          new StubPixel(40),
          new StubPixel(50)
        )
      )
    )

    val flippedImage = new YFlipImageFilter().applyFilter(image)

    compareImagePixels(
      flippedImage,
      createImage(
        Seq(
          Seq(
            new StubPixel(20),
            new StubPixel(10),
            new StubPixel(0)
          ),
          Seq(
            new StubPixel(50),
            new StubPixel(40),
            new StubPixel(30)
          )
        )
      )
    )
  }
}
