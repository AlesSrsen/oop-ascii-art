package ui.views

import ui.views.pages.generic.{ErrorResponse, InfoResponse, SuccessResponse}

class ConsoleView() extends View {
  override def error(message: String): Unit =
    print(new ErrorResponse(message).render())

  override def info(message: String): Unit =
    print(new InfoResponse(message).render())

  override def success(message: String): Unit =
    print(new SuccessResponse(message).render())
}
