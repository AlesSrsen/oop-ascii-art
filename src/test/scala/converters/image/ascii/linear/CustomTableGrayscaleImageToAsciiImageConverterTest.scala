package converters.image.ascii.linear

import asciiApp.models.pixels.GrayscalePixel
import helpers.TestWithImages
import org.scalatest.FunSuite

class CustomTableGrayscaleImageToAsciiImageConverterTest
    extends FunSuite
    with TestWithImages {
  test("Convert image with 256 values of brightness using table of 256 chars") {
    val nums = IndexedSeq(0 to 255).flatten
    val chars = nums.map(v => v.toChar)
    val seqOfPixels: Seq[Seq[GrayscalePixel]] =
      IndexedSeq(
        nums
          .map(gray => new GrayscalePixel(gray)))

    val image = createImage(seqOfPixels)
    val convertedImage =
      new CustomTableGrayscaleImageToAsciiImageConverter(chars)
        .convert(image)

    assert(convertedImage.pixels.getPixelSeq.flatten.map(_.symbol) == chars)
  }

  test("Convert image using table of 1 char") {
    val chars = Seq('a')

    val image = createImage(
      Seq(
        Seq(
          new GrayscalePixel(0),
          new GrayscalePixel(100),
          new GrayscalePixel(200),
          new GrayscalePixel(255)
        )
      )
    )

    val convertedImage =
      new CustomTableGrayscaleImageToAsciiImageConverter(chars)
        .convert(image)

    assert(
      convertedImage.pixels.getPixelSeq.flatten.map(_.symbol) == Seq.fill(4)(
        chars.head))
  }

  test("Convert image using table of 2 chars") {
    val chars = IndexedSeq('a', 'b')

    val image = createImage(
      Seq(
        Seq(
          new GrayscalePixel(0),
          new GrayscalePixel(100),
          new GrayscalePixel(200),
          new GrayscalePixel(255)
        )
      )
    )

    val convertedImage =
      new CustomTableGrayscaleImageToAsciiImageConverter(chars)
        .convert(image)

    assert(
      convertedImage.pixels.getPixelSeq.flatten
        .map(_.symbol) == Seq(chars.head, chars.head, chars.last, chars.last))
  }

  test("Empty custom table") {
    val chars = IndexedSeq.empty[Char]

    val image = createImage(
      Seq(
        Seq(
          new GrayscalePixel(0),
          new GrayscalePixel(100),
          new GrayscalePixel(200),
          new GrayscalePixel(255)
        )
      )
    )

    assertThrows[IllegalArgumentException] {
      new CustomTableGrayscaleImageToAsciiImageConverter(chars)
          .convert(image)
    }
  }

  test("Image with one pixel") {
    val chars = IndexedSeq('a', 'b')

    val image = createImage(
      Seq(
        Seq(
          new GrayscalePixel(0)
        )
      )
    )

    val convertedImage =
      new CustomTableGrayscaleImageToAsciiImageConverter(chars)
        .convert(image)

    assert(
      convertedImage.pixels.getPixelSeq.flatten
        .map(_.symbol) == Seq(chars.head))
  }
}
