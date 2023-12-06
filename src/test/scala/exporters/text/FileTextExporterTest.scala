package exporters.text

import helpers.TestWithFiles
import org.scalatest.{BeforeAndAfter, FunSuite}

import java.io.File

class FileTextExporterTest
    extends FunSuite
    with BeforeAndAfter
    with TestWithFiles {
  var testFile: File = _

  before {
    testFile = getRandomNonExistingTempFile()
  }

  test("Export text to stream with nonexistent file") {
    val exporter = new FileTextExporter(testFile)
    exporter.`export`("Testing export!")
    exporter.close()
    assertFileContent(testFile, "Testing export!")
  }

  test("Export empty text to stream with nonexistent file") {
    val exporter = new FileTextExporter(testFile)
    exporter.`export`("")
    exporter.close()
    assertFileContent(testFile, "")
  }

  test("Export multiple lines to stream with nonexistent file") {
    val exporter = new FileTextExporter(testFile)
    exporter.`export`("Testing export!")
    exporter.`export`("Testing export!")
    exporter.close()
    assertFileContent(testFile, "Testing export!Testing export!")
  }

  test("Close stream with nonexistent file") {
    val exporter = new FileTextExporter(testFile)
    exporter.close()
    assertFileExists(testFile)
  }

  test("Export to already closed stream") {
    val exporter = new FileTextExporter(testFile)
    exporter.close()
    assertThrows[IllegalStateException] {
      exporter.`export`("Testing export!")
    }
  }

  test("Export to existing file") {
    deleteFile(testFile)
    testFile = getRandomExistingTempFile()
    assertFileContent(testFile, "")

    val exporter = new FileTextExporter(testFile)
    exporter.`export`("Testing export!")
    exporter.close()
    assertFileContent(testFile, "Testing export!")
  }

  after {
    deleteFile(testFile)
  }
}
