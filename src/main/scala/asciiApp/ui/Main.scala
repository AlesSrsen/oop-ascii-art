package asciiApp.ui

import asciiApp.ui.controllers.ConsoleController
import asciiApp.ui.views.ConsoleView

object Main extends App {
  private val view = new ConsoleView()
  private val controller = new ConsoleController(args, view)
  try controller.run()
  catch {
    case e: Exception =>
      view.error("An unexpected error occurred: " + e.getMessage)
      sys.exit(1)
  }
}
