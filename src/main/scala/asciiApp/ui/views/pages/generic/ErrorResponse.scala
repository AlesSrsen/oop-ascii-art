package asciiApp.ui.views.pages.generic

import asciiApp.ui.views.pages.TextPage

class ErrorResponse(errorMessage: String = "Error") extends TextPage {
  override def render(): String = "[ERROR] \n" + errorMessage
}
