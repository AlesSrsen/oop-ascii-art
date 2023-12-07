package filters.image.generic

import asciiApp.models.pixels.RGBPixel
import filters.image.generic.flip.XFlipImageFilter
import helpers.TestWithImages
import org.scalatest.FunSuite

class XFlipImageFilterTest extends FunSuite with TestWithImages {
  test("Check flip on square image") {
    val image = createImage(
      Seq(
        Seq(new RGBPixel(0, 0, 0), new RGBPixel(100, 100, 100)),
        Seq(new RGBPixel(200, 200, 200), new RGBPixel(250, 250, 250))
      )
    )

    val flippedImage = new XFlipImageFilter().applyFilter(image)

    compareImagePixels(
      flippedImage,
      createImage(
        Seq(
          Seq(new RGBPixel(200, 200, 200), new RGBPixel(250, 250, 250)),
          Seq(new RGBPixel(0, 0, 0), new RGBPixel(100, 100, 100))
        )
      )
    )
  }

  test("Check flip on a rectangle image") {
    val image = createImage(
      Seq(
        Seq(
          new RGBPixel(0, 0, 0),
          new RGBPixel(10, 10, 10),
          new RGBPixel(20, 20, 20)
        ),
        Seq(
          new RGBPixel(30, 30, 30),
          new RGBPixel(40, 40, 40),
          new RGBPixel(50, 50, 50)
        )
      )
    )

    val flippedImage = new XFlipImageFilter().applyFilter(image)

    compareImagePixels(
      flippedImage,
      createImage(
        Seq(
          Seq(
            new RGBPixel(30, 30, 30),
            new RGBPixel(40, 40, 40),
            new RGBPixel(50, 50, 50)
          ),
          Seq(
            new RGBPixel(0, 0, 0),
            new RGBPixel(10, 10, 10),
            new RGBPixel(20, 20, 20)
          )
        )
      )
    )
  }
}
