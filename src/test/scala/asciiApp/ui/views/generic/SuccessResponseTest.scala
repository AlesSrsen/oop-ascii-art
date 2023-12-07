package asciiApp.ui.views.generic

import asciiApp.ui.views.pages.generic.SuccessResponse
import org.scalatest.FunSuite

class SuccessResponseTest extends FunSuite {
  test("Test success message") {
    val successResponse = new SuccessResponse("test message")
    assert(
      successResponse
        .render() == "[SUCCESS]" + System
        .lineSeparator() + "test message" + System.lineSeparator()
    )
  }

  test("Empty message") {
    val successResponse = new SuccessResponse("")
    assert(
      successResponse
        .render() == "[SUCCESS]" + System.lineSeparator() + "" + System
        .lineSeparator()
    )
  }
}
