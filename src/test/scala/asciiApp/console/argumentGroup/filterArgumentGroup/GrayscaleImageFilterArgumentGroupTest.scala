package asciiApp.console.argumentGroup.filterArgumentGroup

import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter
import org.scalatest.FunSuite

class GrayscaleImageFilterArgumentGroupTest extends FunSuite {
  test("Check if unparsed arguments are kept") {
    val rgbImageLoaderArgumentGroup = new GrayscaleImageFilterArgumentGroup()
    val arguments = rgbImageLoaderArgumentGroup.parse(
      Seq("other", "--invert", "other")
    )
    assert(
      rgbImageLoaderArgumentGroup.getParsingResult.head
        .isInstanceOf[ImageFilter[Image[GrayscalePixel]]])

    assert(arguments == Seq.fill(2)("other"))
  }
}
