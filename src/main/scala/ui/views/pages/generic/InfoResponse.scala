package ui.views.pages.generic

import ui.views.pages.TextPage

class InfoResponse(infoMessage: String) extends TextPage {
  override def render(): String = infoMessage
}
