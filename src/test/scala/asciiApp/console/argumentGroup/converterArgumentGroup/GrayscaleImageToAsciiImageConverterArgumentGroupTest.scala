package asciiApp.console.argumentGroup.converterArgumentGroup

import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter
import org.scalatest.FunSuite

class GrayscaleImageToAsciiImageConverterArgumentGroupTest extends FunSuite {
  test("Check if unparsed arguments are kept") {
    val rgbImageLoaderArgumentGroup =
      new GrayscaleImageToAsciiImageConverterArgumentGroup()
    val arguments = rgbImageLoaderArgumentGroup.parse(
      Seq("other", "--table-bourke", "other")
    )
    assert(
      rgbImageLoaderArgumentGroup.getParsingResult.head
        .isInstanceOf[
          ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]])

    assert(arguments == Seq.fill(2)("other"))
  }
}
