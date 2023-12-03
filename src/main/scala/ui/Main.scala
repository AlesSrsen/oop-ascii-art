package ui

import ui.controllers.ConsoleController
import ui.views.ConsoleView

object Main extends App {
  private val view = new ConsoleView()
  private val controller = new ConsoleController(args, view)
  controller.run()
}
