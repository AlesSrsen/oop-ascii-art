package asciiApp.ui.controllers

import asciiApp.console.argumentGroup.ArgumentGroup
import asciiApp.console.argumentGroup.converterArgumentGroup.GrayscaleImageToAsciiImageConverterArgumentGroup
import asciiApp.console.argumentGroup.exporterArgumentGroup.AsciiImageExporterArgumentGroup
import asciiApp.console.argumentGroup.filterArgumentGroup.GrayscaleImageFilterArgumentGroup
import asciiApp.console.argumentGroup.loaderArgumentGroup.RGBImageLoaderArgumentGroup
import asciiApp.console.exceptions.{InvalidArgumentException, InvalidArgumentOptionException, MissingArgumentException, MissingArgumentOptionException}
import asciiApp.facades.AsciiImageFromImage
import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import asciiApp.ui.views.View
import converters.image.ImageToImageConverter
import converters.image.ascii.linear.BourkeGrayscaleImageToAsciiAsciiImageConverter
import exporters.image.{StdOutAsciiImageExporter, StreamAsciiImageExporter}
import filters.image.ImageFilter
import loaders.image.RGBImageLoader

class ConsoleController(args: Seq[String], view: View) extends Controller {
  private val RGBImageLoaderArgumentGroupInstance =
    new RGBImageLoaderArgumentGroup
  private val GrayscaleImageFilterArgumentGroupInstance =
    new GrayscaleImageFilterArgumentGroup
  private val GrayscaleImageToAsciiImageConverterArgumentGroupInstance =
    new GrayscaleImageToAsciiImageConverterArgumentGroup
  private val AsciiImageExporterArgumentGroupInstance =
    new AsciiImageExporterArgumentGroup

  private val argumentGroups: Seq[ArgumentGroup[_]] = Seq(
    RGBImageLoaderArgumentGroupInstance,
    GrayscaleImageFilterArgumentGroupInstance,
    GrayscaleImageToAsciiImageConverterArgumentGroupInstance,
    AsciiImageExporterArgumentGroupInstance
  )

  override def run(): Unit =
    try {
      parse()

      val loader = getLoader()
      val filters = getFilters()
      val converter = getConverter()
      val exporters = getExporters()

      new AsciiImageFromImage()
        .createAsciiImageFromImage(loader, filters, converter, exporters)

      exporters.foreach(exporter => exporter.close())
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

  private def parse(): Seq[String] = {
    val restOfArguments = argumentGroups.foldLeft(args)(
      (args, argumentGroup) => argumentGroup.parse(args)
    )

    if (restOfArguments.nonEmpty)
      throw new InvalidArgumentException(
        "Invalid argument: " + restOfArguments.head)

    restOfArguments
  }

  private def getLoader(): RGBImageLoader = {
    var loader = RGBImageLoaderArgumentGroupInstance.getParsingResult
    if (loader.isEmpty)
      throw new MissingArgumentException("Missing loader argument")

    if (loader.size > 1)
      throw new InvalidArgumentException("Too many loaders supplied")

    loader.head
  }

  private def getFilters(): Seq[ImageFilter[Image[GrayscalePixel]]] = {
    var filters = GrayscaleImageFilterArgumentGroupInstance.getParsingResult
    filters
  }

  private def getConverter()
    : ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]] = {
    var converter =
      GrayscaleImageToAsciiImageConverterArgumentGroupInstance.getParsingResult
    if (converter.isEmpty)
      converter :+= new BourkeGrayscaleImageToAsciiAsciiImageConverter

    if (converter.size > 1)
      throw new InvalidArgumentException("Too many converters supplied")

    converter.head
  }

  private def getExporters(): Seq[StreamAsciiImageExporter] = {
    var exporters = AsciiImageExporterArgumentGroupInstance.getParsingResult
    if (exporters.isEmpty)
      exporters :+= new StdOutAsciiImageExporter

    exporters
  }
}
