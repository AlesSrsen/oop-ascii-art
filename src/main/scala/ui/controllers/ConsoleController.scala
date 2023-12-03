package ui.controllers

import converters.image.ImageToImageConverter
import converters.image.ascii.linear.{BourkeGrayscaleImageToAsciiAsciiImageConverter, CustomTableGrayscaleImageToAsciiImageConverter, ShortBourkeGrayscaleImageToAsciiAsciiImageConverter}
import converters.image.rgb.BufferedImageToRGBImageConverter
import exporters.image.{FileAsciiImageExporter, ImageExporter, StdOutAsciiImageExporter}
import facades.AsciiImageFromImage
import filters.image.ImageFilter
import filters.image.gray.flip.{XFlipGrayscaleImageFilter, YFlipGrayscaleImageFilter}
import filters.image.gray.{BrightnessGrayscaleImageFilter, InvertGrayscaleImageFilter}
import loaders.image.ImageLoader
import loaders.image.file.RGBImageFileLoader
import models.image.{AsciiImage, GrayscaleImage, RGBImage}
import ui.views.View

import java.io.File

class ConsoleController(args: Seq[String], view: View) extends Controller {
  override def run(): Unit = {
    val loader = parseLoader(args)
    val filters = parseFilters(args)
    val converter = parseConverter(args)
    val exporters = parseExporters(args)
    new AsciiImageFromImage()
      .createAsciiImageFromImage(loader, filters, converter, exporters)
  }

  // TODO fix other sources
  private def parseLoader(args: Seq[String]): ImageLoader[RGBImage] = {
    var foundSource = false
    var sourceIndex = -1

    for (y <- args.indices)
      args(y) match {
        case "--image" =>
          if (foundSource)
            throw new IllegalArgumentException(
              "Multiple input sources specified")
          foundSource = true
          sourceIndex = y + 1
        case _ =>
      }

    if (!foundSource || sourceIndex >= args.length || sourceIndex < 1)
      throw new IllegalArgumentException("Invalid image source specified")

    new RGBImageFileLoader(
      new File(args(sourceIndex)),
      new BufferedImageToRGBImageConverter)
  }

  private def parseFilters(
    args: Seq[String]): Iterable[ImageFilter[GrayscaleImage]] = {
    var list = Array[ImageFilter[GrayscaleImage]]()

    for (y <- args.indices)
      args(y) match {
        case "--brightness" =>
          val amount = args(y + 1).toIntOption
          if (amount.isEmpty)
            throw new IllegalArgumentException(
              "Brightness amount specified incorrectly")
          list :+= (new BrightnessGrayscaleImageFilter(amount.get))
        case "--flip" =>
          args(y + 1) match {
            case "x" => list :+= (new XFlipGrayscaleImageFilter)
            case "y" => list :+= (new YFlipGrayscaleImageFilter)
            case _ =>
              throw new IllegalArgumentException(
                "Flip filter specified incorrectly")
          }
        case "--invert" => list :+= (new InvertGrayscaleImageFilter)
        case _          =>
      }

    list
  }

  private def parseConverter(
    args: Seq[String]): ImageToImageConverter[GrayscaleImage, AsciiImage] = {
    var foundConverter = false
    var sourceIndex = -1
    var converter: ImageToImageConverter[GrayscaleImage, AsciiImage] =
      new BourkeGrayscaleImageToAsciiAsciiImageConverter

    for (y <- args.indices)
      args(y) match {
        case "--bourke" =>
          if (foundConverter)
            throw new IllegalArgumentException("Multiple converters specified")
          foundConverter = true
        case "--bourke-short" =>
          if (foundConverter)
            throw new IllegalArgumentException(
              "Multiple converters specified"
            )
          foundConverter = true
          converter = new ShortBourkeGrayscaleImageToAsciiAsciiImageConverter
        case "--converter" =>
          if (foundConverter)
            throw new IllegalArgumentException("Multiple converters specified")
          foundConverter = true
          converter = new CustomTableGrayscaleImageToAsciiImageConverter(
            args(y + 1))
        case _ =>
      }

    converter
  }

  private def parseExporters(
    args: Seq[String]): Iterable[ImageExporter[AsciiImage]] = {
    var list = Array[ImageExporter[AsciiImage]]()

    for (y <- args.indices)
      args(y) match {
        case "--output-console" =>
          list :+= new StdOutAsciiImageExporter
        case "--output-file" =>
          list :+= new FileAsciiImageExporter(new File(args(y + 1)))
        case _ =>
      }

    list
  }
}
