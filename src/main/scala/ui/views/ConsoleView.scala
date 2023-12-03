package ui.views

import ui.views.pages.generic.ErrorResponse

class ConsoleView() extends View {
  override def error(message: String): Unit =
    System.out.println(new ErrorResponse(message))

  override def info(message: String): Unit = ???

  override def success(message: String): Unit = ???
}
