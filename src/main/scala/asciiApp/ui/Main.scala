package asciiApp.ui

import asciiApp.ui.controllers.ConsoleController
import asciiApp.ui.views.ConsoleView

object Main extends App {
  private val view = new ConsoleView()
  private val controller = new ConsoleController(args, view)
  controller.run()
}
