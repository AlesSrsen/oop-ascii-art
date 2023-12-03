package console

import converters.image.ascii.linear.BourkeGrayscaleImageToAsciiAsciiImageConverter
import converters.image.gray.RGBImageToGrayscaleImageConverter
import converters.image.rgb.BufferedImageToRGBImageConverter
import exporters.image.StdOutAsciiImageExporter
import filters.image.MixedImageFilter
import filters.image.gray.flip.{XFlipGrayscaleImageFilter, YFlipGrayscaleImageFilter}
import filters.image.gray.{BrightnessGrayscaleImageFilter, InvertGrayscaleImageFilter}
import loaders.image.file.RGBImageFileLoader

import java.io.File

object Main extends App {
  val appImage = new RGBImageFileLoader(
    new File("src/main/resources/images/linear_gradient_a.png"),
    new BufferedImageToRGBImageConverter).load();
  val grayscaleImage = new RGBImageToGrayscaleImageConverter().convert(appImage)

  val filter = new MixedImageFilter(
    List(
      new BrightnessGrayscaleImageFilter(10),
      new BrightnessGrayscaleImageFilter(10),
      new BrightnessGrayscaleImageFilter(10),
      new XFlipGrayscaleImageFilter,
      new XFlipGrayscaleImageFilter,
      new YFlipGrayscaleImageFilter,
      new InvertGrayscaleImageFilter
    ))
  val filteredImage = filter.applyFilter(grayscaleImage)

  val asciiImage = new BourkeGrayscaleImageToAsciiAsciiImageConverter()
    .convert(filteredImage)
  new StdOutAsciiImageExporter()
    .export(asciiImage)
}
