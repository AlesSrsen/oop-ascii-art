package asciiApp.ui.views.pages.generic

import asciiApp.ui.views.pages.TextPage

class ErrorResponse(errorMessage: String = "Undefined error") extends TextPage {
  override def render(): String =
    "[ERROR]" + System.lineSeparator() + errorMessage + System.lineSeparator()
}
