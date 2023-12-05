package asciiApp.ui.views.pages.generic

import asciiApp.ui.views.pages.TextPage

class InfoResponse(infoMessage: String) extends TextPage {
  override def render(): String = infoMessage
}
