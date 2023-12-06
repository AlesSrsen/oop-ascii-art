package exporters.image

import asciiApp.models.pixels.AsciiPixel
import helpers.{TestWithFiles, TestWithImages}
import org.scalatest.{BeforeAndAfter, FunSuite}

import java.io.File

class FileAsciiImageExporterTest
    extends FunSuite
    with TestWithFiles
    with TestWithImages
    with BeforeAndAfter {
  var testFile: File = _

  before {
    testFile = getRandomNonExistingTempFile()
  }

  test("Export multiple lines to file") {
    val exporter = new FileAsciiImageExporter(testFile)
    exporter.`export`(
      createImage(
        Seq(
          Seq(AsciiPixel('a')),
          Seq(AsciiPixel('b')),
          Seq(AsciiPixel('c'))
        )
      )
    )
    exporter.close()
    assertFileContent(
      testFile,
      "a" + System.lineSeparator() + "b" + System.lineSeparator() + "c"
    );
  }

  test("Export image with one pixel to file") {
    val exporter = new FileAsciiImageExporter(testFile)
    exporter.`export`(
      createImage(
        Seq(
          Seq(AsciiPixel('*'))
        )
      )
    )
    exporter.close()
    assertFileContent(testFile, "*");
  }

  test("Export multiple rows to file") {
    val exporter = new FileAsciiImageExporter(testFile)
    exporter.`export`(
      createImage(
        Seq(
          Seq(AsciiPixel('a'), AsciiPixel('b'), AsciiPixel('c')),
          Seq(AsciiPixel('d'), AsciiPixel('e'), AsciiPixel('f'))
        )
      )
    )
    exporter.close()
    assertFileContent(testFile, "abc" + System.lineSeparator() + "def");
  }

  test("Export to already closed stream") {
    val exporter = new FileAsciiImageExporter(testFile)
    exporter.close()
    assertThrows[IllegalStateException] {
      exporter.`export`(
        createImage(
          Seq(
            Seq(AsciiPixel('*')),
          )
        )
      )
    }
  }

  test("Export to existing file") {
    deleteFile(testFile)
    testFile = getRandomExistingTempFile()
    assertFileContent(testFile, "")

    val exporter = new FileAsciiImageExporter(testFile)
    exporter.`export`(
      createImage(
        Seq(
          Seq(AsciiPixel('*')),
        )
      )
    )
    exporter.close()
    assertFileContent(testFile, "*")
  }

  after {
    deleteFile(testFile)
  }
}
