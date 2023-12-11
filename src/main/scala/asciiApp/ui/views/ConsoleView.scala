package asciiApp.ui.views

import asciiApp.ui.views.pages.generic.{
  ErrorResponse,
  InfoResponse,
  SuccessResponse
}

import java.io.OutputStream

/**
 * Console view implementation
 * @param output output stream
 */
class ConsoleView(output: OutputStream = System.out) extends View {
  override def error(message: String): Unit =
    output.write(new ErrorResponse(message).render().getBytes("UTF-8"))

  override def info(message: String): Unit =
    output.write(new InfoResponse(message).render().getBytes("UTF-8"))

  override def success(message: String): Unit =
    output.write(new SuccessResponse(message).render().getBytes("UTF-8"))
}
