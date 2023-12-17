package converters.image.ascii.linear

import asciiApp.models.pixels.GrayscalePixel
import helpers.TestWithImages
import org.scalatest.{BeforeAndAfter, FunSuite}

class ShortBourkeGrayscaleImageToAsciiImageConverterTest
    extends FunSuite
    with TestWithImages
    with BeforeAndAfter {

  var converter: ShortBourkeGrayscaleImageToAsciiImageConverter = _

  before {
    converter = new ShortBourkeGrayscaleImageToAsciiImageConverter()
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
          new GrayscalePixel(63),
          new GrayscalePixel(127)
        ),
        Seq(
          new GrayscalePixel(128),
          new GrayscalePixel(191),
          new GrayscalePixel(255)
        )
      )
    )

    val convertedImage =
      converter
        .convert(image)

    assert(
      convertedImage.pixels.getPixelSeq.flatten.map(_.symbol) == Seq('@', '#',
        '+', '=', '-', ' '))
  }
}
