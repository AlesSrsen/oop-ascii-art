package asciiApp.ui.views.pages.generic

import asciiApp.ui.views.pages.TextPage

class SuccessResponse(successMessage: String) extends TextPage {
  override def render(): String =
    "[SUCCESS]" + System.lineSeparator() + successMessage + System
      .lineSeparator()
}
