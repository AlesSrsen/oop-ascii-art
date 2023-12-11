package exporters.text

import org.scalatest.{BeforeAndAfter, FunSuite}

import java.io.ByteArrayOutputStream

// I was unable to test this with System.out
class StdOutTextExporterTest extends FunSuite with BeforeAndAfter {
  var testStream: ByteArrayOutputStream = _
  var exporter: StdOutTextExporter = _

  before {
    testStream = new ByteArrayOutputStream()
    exporter = new StdOutTextExporter(testStream)
  }

  test("Export text to stream") {
    exporter.`export`("Testing export!")
    assert(testStream.toString() == "Testing export!")
  }

  test("Export empty text to stream") {
    exporter.`export`("")
    assert(testStream.toString() == "")
  }

  test("Export multiple lines to stream") {
    exporter.`export`("Testing export!")
    exporter.`export`("Testing export!")
    assert(testStream.toString() == "Testing export!Testing export!")
  }

  test("Close stream") {
    exporter.close()
    assert(testStream.toString() == "")
  }

  test("Export to already closed stream") {
    exporter.close()
    assertThrows[IllegalStateException] {
      exporter.`export`("Testing export!")
    }
  }
}
