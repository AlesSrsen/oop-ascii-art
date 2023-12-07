package exporters.image

import asciiApp.models.pixels.AsciiPixel
import helpers.TestWithImages
import org.scalatest.{BeforeAndAfter, FunSuite}

import java.io.ByteArrayOutputStream

class StreamAsciiImageExporterTest
    extends FunSuite
    with BeforeAndAfter
    with TestWithImages {
  var testStream: ByteArrayOutputStream = _

  before {
    testStream = new ByteArrayOutputStream()
  }

  test("Export multiple lines to stream") {
    val exporter = new StreamAsciiImageExporter(testStream)
    exporter.`export`(
      createImage(
        Seq(
          Seq(AsciiPixel('a')),
          Seq(AsciiPixel('b')),
          Seq(AsciiPixel('c'))
        )
      )
    )
    assert(
      testStream.toString() == "a" + System.lineSeparator() + "b" + System
        .lineSeparator() + "c")
  }

  test("Export image with one pixel to stream") {
    val exporter = new StreamAsciiImageExporter(testStream)
    exporter.`export`(
      createImage(
        Seq(
          Seq(AsciiPixel('*'))
        )
      )
    )
    assert(testStream.toString() == "*")
  }

  test("Export multiple rows to stream") {
    val exporter = new StreamAsciiImageExporter(testStream)
    exporter.`export`(
      createImage(
        Seq(
          Seq(AsciiPixel('a'), AsciiPixel('b'), AsciiPixel('c')),
          Seq(AsciiPixel('d'), AsciiPixel('e'), AsciiPixel('f'))
        )
      )
    )
    assert(testStream.toString() == "abc" + System.lineSeparator() + "def")
  }
}
