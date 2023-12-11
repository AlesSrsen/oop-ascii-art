package asciiApp.ui

import asciiApp.ui.controllers.ConsoleController
import asciiApp.ui.views.ConsoleView

/**
 * This application converts multiple formats of images to ASCII art.
 * It is a command line application.
 * It is possible to specify multiple types of loaders of images, also filters, converters and exporters.
 * Check README.md for more information.
 */
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
