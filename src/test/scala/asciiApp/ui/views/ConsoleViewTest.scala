package asciiApp.ui.views

import org.scalatest.{BeforeAndAfter, FunSuite}

import java.io.ByteArrayOutputStream

class ConsoleViewTest extends FunSuite with BeforeAndAfter {
  var consoleView: ConsoleView = _
  var testStream: ByteArrayOutputStream = _

  before {
    testStream = new ByteArrayOutputStream()
    consoleView = new ConsoleView(testStream)
  }

  test("Render error message") {
    consoleView.error("test message")
    assert(
      testStream.toString == "[ERROR]" + System
        .lineSeparator() + "test message" + System.lineSeparator()
    )
  }

  test("Render success message") {
    consoleView.success("test message")
    assert(
      testStream.toString == "[SUCCESS]" + System
        .lineSeparator() + "test message" + System.lineSeparator()
    )
  }

  test("Render info message") {
    consoleView.info("test message")
    assert(
      testStream.toString == "[INFO]" + System
        .lineSeparator() + "test message" + System.lineSeparator()
    )
  }
}
