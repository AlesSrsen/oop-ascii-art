package asciiApp.console

import asciiApp.console.argumentGroup.converterArgumentGroup.GrayscaleImageToAsciiImageConverterArgumentGroup
import asciiApp.console.argumentGroup.exporterArgumentGroup.AsciiImageExporterArgumentGroup
import asciiApp.console.argumentGroup.filterArgumentGroup.GrayscaleImageFilterArgumentGroup
import asciiApp.console.argumentGroup.loaderArgumentGroup.RGBImageLoaderArgumentGroup
import asciiApp.console.exceptions.{InvalidArgumentException, MissingArgumentException}
import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter
import converters.image.ascii.linear.BourkeGrayscaleImageToAsciiAsciiImageConverter
import exporters.image.{ImageExporter, StdOutAsciiImageExporter}
import filters.image.ImageFilter
import loaders.image.RGBImageLoader

class ArgumentParser(args: Seq[String]) {
  private val loaderArgumentGroup = new RGBImageLoaderArgumentGroup
  private val filterArgumentGroup = new GrayscaleImageFilterArgumentGroup
  private val converterArgumentGroup =
    new GrayscaleImageToAsciiImageConverterArgumentGroup
  private val exporterArgumentGroup = new AsciiImageExporterArgumentGroup
  private val argumentGroup = Seq(
    loaderArgumentGroup,
    filterArgumentGroup,
    converterArgumentGroup,
    exporterArgumentGroup
  )
  private var _loader = Option.empty[RGBImageLoader]
  private var _filters = Seq.empty[ImageFilter[Image[GrayscalePixel]]]
  private var _converter =
    Option
      .empty[ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]]
  private var _exporters = Seq.empty[ImageExporter[Image[AsciiPixel]]]

  print(
    argumentGroup
      .map(arg =>
        arg.groupSpecification().map(_.mkString(" | ")).mkString("\n"))
      .mkString("\n---------------------\n") + "\n\n")
  private var argsToParse = args

  def loader: RGBImageLoader = _loader.get

  def filters: Iterable[ImageFilter[Image[GrayscalePixel]]] = _filters

  def converter
    : ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]] =
    _converter.get

  def exporters: Iterable[ImageExporter[Image[AsciiPixel]]] = _exporters

  while (argsToParse.nonEmpty) {
    var parsedInThisRound = false

    val (parsedLoader, newArgs) = loaderArgumentGroup.tryParseTop(argsToParse)
    if (parsedLoader.isDefined && _loader.isEmpty) {
      _loader = parsedLoader
      parsedInThisRound = true
      argsToParse = newArgs
    } else if (parsedLoader.isDefined && _loader.isDefined)
      throw new InvalidArgumentException("Multiple loaders specified")

    if (!parsedInThisRound) {
      val (parsedFilter, newArgs) =
        filterArgumentGroup.tryParseTop(argsToParse)
      if (parsedFilter.isDefined) {
        _filters :+= parsedFilter.get
        parsedInThisRound = true
        argsToParse = newArgs
      }
    }

    if (!parsedInThisRound) {
      val (parsedConverter, newArgs) =
        converterArgumentGroup.tryParseTop(argsToParse)
      if (parsedConverter.isDefined && _converter.isEmpty) {
        _converter = parsedConverter
        parsedInThisRound = true
        argsToParse = newArgs
      } else if (parsedConverter.isDefined && _converter.isDefined)
        throw new InvalidArgumentException("Multiple converters specified")
    }

    if (!parsedInThisRound) {
      val (parsedExporter, newArgs) =
        exporterArgumentGroup.tryParseTop(argsToParse)
      if (parsedExporter.isDefined) {
        _exporters :+= parsedExporter.get
        parsedInThisRound = true
        argsToParse = newArgs
      }
    }

    if (!parsedInThisRound)
      throw new InvalidArgumentException(argsToParse.head)
  }

  if (_loader.isEmpty)
    throw new MissingArgumentException("No loader specified")

  if (_converter.isEmpty)
    _converter = Some(new BourkeGrayscaleImageToAsciiAsciiImageConverter)

  if (_exporters.isEmpty)
    _exporters :+= new StdOutAsciiImageExporter
}
