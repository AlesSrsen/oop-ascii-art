package ui.views.pages.generic

import ui.views.pages.TextPage

class SuccessResponse(successMessage: String) extends TextPage {
  override def render(): String = successMessage
}
