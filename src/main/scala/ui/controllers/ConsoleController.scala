package ui.controllers

import console.ArgumentParser
import console.exceptions.{InvalidArgumentException, InvalidArgumentOptionException, MissingArgumentException, MissingArgumentOptionException}
import facades.AsciiImageFromImage
import ui.views.View

class ConsoleController(args: Seq[String], view: View) extends Controller {
  override def run(): Unit =
    try {
      val argumentParser = new ArgumentParser(args)
      new AsciiImageFromImage()
        .createAsciiImageFromImage(
          argumentParser.loader,
          argumentParser.filters,
          argumentParser.converter,
          argumentParser.exporters)
    } catch {
      case e: MissingArgumentOptionException =>
        view.error("Argument option missing: " + e.getMessage)
      case e: InvalidArgumentOptionException =>
        view.error("Invalid option supplied to an argument: " + e.getMessage)
      case e: MissingArgumentException =>
        view.error("Missing argument: " + e.getMessage)
      case e: InvalidArgumentException =>
        view.error("Invalid argument: " + e.getMessage)
      case e: RuntimeException =>
        view.error("An unexpected error occurred: " + e.getMessage)
    }

}
