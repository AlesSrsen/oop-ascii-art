package asciiApp.facades

import converters.image.ascii.linear.BourkeGrayscaleImageToAsciiImageConverter
import exporters.image.StreamAsciiImageExporter
import exporters.text.StreamTextExporter
import helpers.TestWithFiles
import loaders.image.file.PNGRGBImageFileLoader
import org.scalatest.{BeforeAndAfter, FunSuite}

import java.io.ByteArrayOutputStream

class AsciiImageFromImageTest
    extends FunSuite
    with BeforeAndAfter
    with TestWithFiles {
  var asciiImageFromImage: AsciiImageFromImage = _

  before {
    asciiImageFromImage = new AsciiImageFromImage()
  }

  test("Basic convert Image to Ascii") {
    val outputStream = new ByteArrayOutputStream()
    asciiImageFromImage.createAsciiImageFromImage(
      new PNGRGBImageFileLoader(
        getImageFromResources("testing_grid_image.png")),
      Seq.empty,
      new BourkeGrayscaleImageToAsciiImageConverter(),
      Seq(new StreamAsciiImageExporter(new StreamTextExporter(outputStream)))
    )

    assert(outputStream.toString == "$O\\# " + System.lineSeparator() + ";Y[U ")
  }
}
