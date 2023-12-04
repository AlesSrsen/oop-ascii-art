package ui.controllers

import console.ArgumentLoader
import facades.AsciiImageFromImage
import ui.views.View

class ConsoleController(args: Seq[String], view: View) extends Controller {
  override def run(): Unit = {
    val argumentLoader = new ArgumentLoader(args)
    new AsciiImageFromImage()
      .createAsciiImageFromImage(
        argumentLoader.loader,
        argumentLoader.filters,
        argumentLoader.converter,
        argumentLoader.exporters)
  }
}
