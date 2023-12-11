package converters.image.ascii.nonlinear

import asciiApp.models.pixels.GrayscalePixel
import helpers.TestWithImages
import org.scalatest.{BeforeAndAfter, FunSuite}

class DefaultNonlinearGrayscaleImageToAsciiImageConverterTest
    extends FunSuite
    with TestWithImages
    with BeforeAndAfter {

  var converter: DefaultNonlinearGrayscaleImageToAsciiImageConverter = _

  before {
    converter = new DefaultNonlinearGrayscaleImageToAsciiImageConverter()
  }

  test("Convert black pixels to ascii") {
    val image = createImage(
      Seq(
        Seq(
          new GrayscalePixel(0),
          new GrayscalePixel(0)
        ),
        Seq(
          new GrayscalePixel(0),
          new GrayscalePixel(0)
        )
      )
    )

    val convertedImage =
      converter
        .convert(image)

    assert(
      convertedImage.pixels.getPixelSeq.flatten.map(_.symbol) == Seq.fill(4)(
        '@'))
  }

  test("Convert white pixels to ascii") {
    val image = createImage(
      Seq(
        Seq(
          new GrayscalePixel(255),
          new GrayscalePixel(255)
        ),
        Seq(
          new GrayscalePixel(255),
          new GrayscalePixel(255)
        )
      )
    )

    val convertedImage =
      converter
        .convert(image)

    assert(
      convertedImage.pixels.getPixelSeq.flatten.map(_.symbol) == Seq.fill(4)(
        ' '))
  }

  test("Convert pixels to ascii") {
    val image = createImage(
      Seq(
        Seq(
          new GrayscalePixel(0),
          new GrayscalePixel(28),
          new GrayscalePixel(30)
        ),
        Seq(
          new GrayscalePixel(250),
          new GrayscalePixel(252),
          new GrayscalePixel(255)
        )
      )
    )

    val convertedImage =
      converter
        .convert(image)

    assert(
      convertedImage.pixels.getPixelSeq.flatten.map(_.symbol) == Seq('@', '=', ';', '~', ',', ' '))
  }
}
