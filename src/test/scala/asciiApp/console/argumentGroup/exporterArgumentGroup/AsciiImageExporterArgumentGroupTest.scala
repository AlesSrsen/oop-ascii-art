package asciiApp.console.argumentGroup.exporterArgumentGroup

import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import exporters.image.ImageExporter
import filters.image.ImageFilter
import org.scalatest.FunSuite

class AsciiImageExporterArgumentGroupTest extends FunSuite {
  test("Check if unparsed arguments are kept") {
    val rgbImageLoaderArgumentGroup = new AsciiImageExporterArgumentGroup()
    val arguments = rgbImageLoaderArgumentGroup.parse(
      Seq("other", "--output-console", "other")
    )
    assert(
      rgbImageLoaderArgumentGroup.getParsingResult.head
        .isInstanceOf[ImageExporter[Image[AsciiPixel]]])

    assert(arguments == Seq.fill(2)("other"))
  }
}
