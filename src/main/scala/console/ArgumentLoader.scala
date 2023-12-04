package console

import console.argumentGroup.converterArgumentGroup.ConverterArgumentGroup
import console.argumentGroup.exporterArgumentGroup.ExporterArgumentGroup
import console.argumentGroup.filterArgumentGroup.FilterArgumentGroup
import console.argumentGroup.loaderArgumentGroup.LoaderArgumentGroup
import converters.image.ImageToImageConverter
import converters.image.ascii.linear.BourkeGrayscaleImageToAsciiAsciiImageConverter
import exporters.image.{ImageExporter, StdOutAsciiImageExporter}
import filters.image.ImageFilter
import loaders.image.RGBImageLoader
import models.image.{AsciiImage, GrayscaleImage}

class ArgumentLoader(args: Seq[String]) {
  private val loaderArgumentGroup = new LoaderArgumentGroup
  private val filterArgumentGroup = new FilterArgumentGroup
  private val converterArgumentGroup = new ConverterArgumentGroup
  private val exporterArgumentGroup = new ExporterArgumentGroup

  private var _loader = Option.empty[RGBImageLoader]
  private var _filters = Seq.empty[ImageFilter[GrayscaleImage]]
  private var _converter =
    Option.empty[ImageToImageConverter[GrayscaleImage, AsciiImage]]
  private var _exporters = Seq.empty[ImageExporter[AsciiImage]]

  def loader: RGBImageLoader = _loader.get
  def filters: Iterable[ImageFilter[GrayscaleImage]] = _filters
  def converter: ImageToImageConverter[GrayscaleImage, AsciiImage] =
    _converter.get
  def exporters: Iterable[ImageExporter[AsciiImage]] = _exporters

  private var argsToParse = args

  while (argsToParse.nonEmpty) {
    var parsedInThisRound = false

    val (parsedLoader, newArgs) = loaderArgumentGroup.getLoader(argsToParse)
    if (parsedLoader.isDefined && _loader.isEmpty) {
      _loader = parsedLoader
      parsedInThisRound = true
      argsToParse = newArgs
    } else if (parsedLoader.isDefined && _loader.isDefined)
      throw new IllegalArgumentException("Multiple loaders specified")

    if (!parsedInThisRound) {
      val (parsedFilter, newArgs) =
        filterArgumentGroup.getGrayscaleImageFilter(argsToParse)
      if (parsedFilter.isDefined) {
        _filters :+= parsedFilter.get
        parsedInThisRound = true
        argsToParse = newArgs
      }
    }

    if (!parsedInThisRound) {
      val (parsedConverter, newArgs) =
        converterArgumentGroup.getGrayscaleImageFilter(argsToParse)
      if (parsedConverter.isDefined && _converter.isEmpty) {
        _converter = parsedConverter
        parsedInThisRound = true
        argsToParse = newArgs
      } else if (parsedConverter.isDefined && _converter.isDefined)
        throw new IllegalArgumentException("Multiple converters specified")
    }

    if (!parsedInThisRound) {
      val (parsedExporter, newArgs) =
        exporterArgumentGroup.getAsciiImageExporter(argsToParse)
      if (parsedExporter.isDefined) {
        _exporters :+= parsedExporter.get
        parsedInThisRound = true
        argsToParse = newArgs
      }
    }

    if (!parsedInThisRound)
      throw new IllegalArgumentException(
        "Invalid argument: " + argsToParse.head)
  }

  if (_loader.isEmpty)
    throw new IllegalArgumentException("No loader specified")

  if (_converter.isEmpty)
    _converter = Some(new BourkeGrayscaleImageToAsciiAsciiImageConverter)

  if (_exporters.isEmpty)
    _exporters :+= new StdOutAsciiImageExporter
}
