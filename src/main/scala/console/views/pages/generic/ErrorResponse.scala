package console.views.pages.generic

import console.views.pages.TextPage

class ErrorResponse(errorMessage: String = "Error") extends TextPage {
  override def render(): String = {
    return errorMessage
  }
}
