package console.views.pages.generic

import console.views.pages.TextPage

class SuccessResponse(successMessage: String) extends TextPage {
  override def render(): String = {
    return successMessage
  }
}
