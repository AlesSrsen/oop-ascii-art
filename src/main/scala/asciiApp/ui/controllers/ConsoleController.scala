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
import converters.image.ascii.linear.BourkeGrayscaleImageToAsciiImageConverter
import exporters.image.StreamAsciiImageExporter
import exporters.text.StdOutTextExporter
import filters.image.ImageFilter
import loaders.image.RGBImageLoader

/**
 * Controller for the console application
 * Parses arguments and runs the application
 * Also handles errors.
 *
 * By default there has to be a loader specified, otherwise an error is thrown.
 * If no filters are specified, no filters are used.
 * If no converter is specified, BourkeGrayscaleImageToAsciiImageConverter is used.
 * If no exporters are specified, Image is exported to the console.
 *
 * @param args Arguments passed to the application
 * @param view View used to display errors
 */
class ConsoleController(args: Seq[String], view: View) extends Controller {

  /**
   * Argument groups used to parse arguments
   */
  private val RGBImageLoaderArgumentGroupInstance =
    new RGBImageLoaderArgumentGroup
  private val GrayscaleImageFilterArgumentGroupInstance =
    new GrayscaleImageFilterArgumentGroup
  private val GrayscaleImageToAsciiImageConverterArgumentGroupInstance =
    new GrayscaleImageToAsciiImageConverterArgumentGroup
  private val AsciiImageExporterArgumentGroupInstance =
    new AsciiImageExporterArgumentGroup

  /**
   * All argument groups in sequence, to be parsed in order
   */
  private val argumentGroups: Seq[ArgumentGroup[_]] = Seq(
    RGBImageLoaderArgumentGroupInstance,
    GrayscaleImageFilterArgumentGroupInstance,
    GrayscaleImageToAsciiImageConverterArgumentGroupInstance,
    AsciiImageExporterArgumentGroupInstance
  )

  /**
   * Parses arguments and runs the application using AsciiImageFromImage facade
   */
  override def run(): Unit = {
    var exporters = Seq.empty[StreamAsciiImageExporter]
    try {
      parseArguments()
      val loader = getLoader()
      val filters = getFilters()
      val converter = getConverter()
      exporters = getExporters()

      new AsciiImageFromImage()
        .createAsciiImageFromImage(loader, filters, converter, exporters)

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
        throw e
    } finally exporters.foreach(exporter => exporter.close())
  }

  /**
   * Parses the arguments passed to the application using the argument groups defined
   * @throws MissingArgumentException if there are any arguments left after parsing
   *                                  Other exceptions are thrown by the argument group, and arguments themselves
   * @return remaining arguments
   */
  private def parseArguments(): Seq[String] = {
    val restOfArguments = argumentGroups.foldLeft(args)(
      (args, argumentGroup) => argumentGroup.parse(args)
    )

    if (restOfArguments.nonEmpty)
      throw new InvalidArgumentException(restOfArguments.head)

    restOfArguments
  }

  /**
   * Gets the loader from the argument group
   * @throws MissingArgumentException if no loader is specified
   * @throws InvalidArgumentException if too many loaders are specified
   *                                  Other exceptions are thrown by the argument group, and arguments themselves
   * @return loader
   */
  private def getLoader(): RGBImageLoader = {
    var loader = RGBImageLoaderArgumentGroupInstance.getParsingResult
    if (loader.isEmpty)
      throw new MissingArgumentException("No loader specified")

    if (loader.size > 1)
      throw new InvalidArgumentException("Too many loaders supplied")

    loader.head
  }

  /**
   * Gets the filters from the argument group
   * Exceptions can be thrown by the argument group, and arguments themselves
   * @return filters
   */
  private def getFilters(): Seq[ImageFilter[Image[GrayscalePixel]]] = {
    var filters = GrayscaleImageFilterArgumentGroupInstance.getParsingResult
    filters
  }

  /**
   * Gets the converter from the argument group
   * If no converter is specified, BourkeGrayscaleImageToAsciiImageConverter is used
   * @throws InvalidArgumentException if too many converters are specified
   *                                  Other exceptions are thrown by the argument group, and arguments themselves
   * @return converter
   */
  private def getConverter()
    : ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]] = {
    var converter =
      GrayscaleImageToAsciiImageConverterArgumentGroupInstance.getParsingResult
    if (converter.isEmpty)
      converter :+= new BourkeGrayscaleImageToAsciiImageConverter

    if (converter.size > 1)
      throw new InvalidArgumentException("Too many converters supplied")

    converter.head
  }

  /**
   * Gets the exporters from the argument group
   * If no exporters are specified, Image is exported to the console
   * Exceptions can be thrown by the argument group, and arguments themselves
   * @return exporters
   */
  private def getExporters(): Seq[StreamAsciiImageExporter] = {
    var exporters = AsciiImageExporterArgumentGroupInstance.getParsingResult
    if (exporters.isEmpty)
      exporters :+= new StreamAsciiImageExporter(new StdOutTextExporter)

    exporters
  }
}
