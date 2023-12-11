package converters.image.ascii.nonlinear

import asciiApp.models.pixels.GrayscalePixel
import helpers.TestWithImages
import org.scalatest.{BeforeAndAfter, FunSuite}

class OutliersNonlinearGrayscaleImageToAsciiImageConverterTest
    extends FunSuite
    with TestWithImages
    with BeforeAndAfter {

  var converter: OutliersNonlinearGrayscaleImageToAsciiImageConverter = _

  before {
    converter = new OutliersNonlinearGrayscaleImageToAsciiImageConverter()
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
        '*'))
  }

  test("Convert pixels to ascii") {
    val image = createImage(
      Seq(
        Seq(
          new GrayscalePixel(0),
          new GrayscalePixel(50),
          new GrayscalePixel(125)
        ),
        Seq(
          new GrayscalePixel(200),
          new GrayscalePixel(225),
          new GrayscalePixel(255)
        )
      )
    )

    val convertedImage =
      converter
        .convert(image)

    assert(
      convertedImage.pixels.getPixelSeq.flatten.map(_.symbol) == Seq('@', ' ',
        ' ', ' ', ' ', '*'))
  }

  test("Convert pixels to ascii near bounds of 2% outlier value") {
    val image = createImage(
      Seq(
        Seq(
          new GrayscalePixel(0),
          new GrayscalePixel(1),
          new GrayscalePixel(4),
          new GrayscalePixel(5)
        ),
        Seq(
          new GrayscalePixel(249),
          new GrayscalePixel(250),
          new GrayscalePixel(254),
          new GrayscalePixel(255)
        )
      )
    )

    val convertedImage =
      converter
        .convert(image)

    assert(
      convertedImage.pixels.getPixelSeq.flatten.map(_.symbol) == Seq('@', '@',
        '@', ' ', ' ', '*', '*', '*'))
  }
}
