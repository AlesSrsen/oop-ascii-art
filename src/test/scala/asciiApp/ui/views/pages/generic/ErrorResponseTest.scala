package asciiApp.ui.views.pages.generic

import asciiApp.ui.views.pages.generic.ErrorResponse
import org.scalatest.FunSuite

class ErrorResponseTest extends FunSuite {
  test("Test error message") {
    val errorResponse = new ErrorResponse("test message")
    assert(
      errorResponse
        .render() == "[ERROR]" + System
        .lineSeparator() + "test message" + System.lineSeparator()
    )
  }

  test("Empty message") {
    val errorResponse = new ErrorResponse("")
    assert(
      errorResponse
        .render() == "[ERROR]" + System.lineSeparator() + "" + System
        .lineSeparator()
    )
  }

  test("Default message") {
    val errorResponse = new ErrorResponse()
    assert(
      errorResponse
        .render() == "[ERROR]" + System.lineSeparator() + "Undefined error" + System
        .lineSeparator()
    )
  }
}
