package asciiApp.ui.views.pages.generic

import asciiApp.ui.views.pages.generic.InfoResponse
import org.scalatest.FunSuite

class InfoResponseTest extends FunSuite {
  test("Test info message") {
    val infoResponse = new InfoResponse("test message")
    assert(
      infoResponse
        .render() == "[INFO]" + System
        .lineSeparator() + "test message" + System.lineSeparator()
    )
  }

  test("Empty message") {
    val infoResponse = new InfoResponse("")
    assert(
      infoResponse
        .render() == "[INFO]" + System.lineSeparator() + "" + System
        .lineSeparator()
    )
  }
}
