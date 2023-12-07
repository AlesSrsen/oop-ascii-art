package filters.image.gray

import asciiApp.models.pixels.GrayscalePixel
import helpers.TestWithImages
import org.scalatest.FunSuite

class InvertGrayscaleImageFilterTest extends FunSuite with TestWithImages {
  test("Check inversion on square image with edge values") {
    val image = createImage(
      Seq(
        Seq(new GrayscalePixel(0), new GrayscalePixel(255)),
        Seq(new GrayscalePixel(255), new GrayscalePixel(0))
      )
    )

    val invertedImage = new InvertGrayscaleImageFilter().applyFilter(image)

    compareImagePixels(
      invertedImage,
      createImage(
        Seq(
          Seq(new GrayscalePixel(255), new GrayscalePixel(0)),
          Seq(new GrayscalePixel(0), new GrayscalePixel(255))
        )
      )
    )
  }

  test("Check inversion on a rectangle image with middle values") {
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

    val invertedImage = new InvertGrayscaleImageFilter().applyFilter(image)

    compareImagePixels(
      invertedImage,
      createImage(
        Seq(
          Seq(
            new GrayscalePixel(255),
            new GrayscalePixel(0),
            new GrayscalePixel(155)
          ),
          Seq(
            new GrayscalePixel(0),
            new GrayscalePixel(255),
            new GrayscalePixel(155)
          )
        )
      )
    )
  }
}
