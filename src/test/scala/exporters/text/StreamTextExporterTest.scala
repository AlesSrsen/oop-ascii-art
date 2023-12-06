package exporters.text

import org.scalatest.{BeforeAndAfter, FunSuite}

import java.io.ByteArrayOutputStream

class StreamTextExporterTest extends FunSuite with BeforeAndAfter {
  var testStream: ByteArrayOutputStream = _

  before {
    testStream = new ByteArrayOutputStream()
  }

  test("Export text to stream") {
    val exporter = new StreamTextExporter(testStream)
    exporter.`export`("Testing export!")
    assert(testStream.toString() == "Testing export!")
  }

  test("Export empty text to stream") {
    val exporter = new StreamTextExporter(testStream)
    exporter.`export`("")
    assert(testStream.toString() == "")
  }

  test("Export multiple lines to stream") {
    val exporter = new StreamTextExporter(testStream)
    exporter.`export`("Testing export!")
    exporter.`export`("Testing export!")
    assert(testStream.toString() == "Testing export!Testing export!")
  }

  test("Close stream") {
    val exporter = new StreamTextExporter(testStream)
    exporter.close()
    assert(testStream.toString() == "")
  }

  test("Export to already closed stream") {
    val exporter = new StreamTextExporter(testStream)
    exporter.close()
    assertThrows[IllegalStateException] {
      exporter.`export`("Testing export!")
    }
  }
}
