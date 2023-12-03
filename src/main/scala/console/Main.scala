package console

import converters.image.ascii.linear.BourkeGrayscaleImageToAsciiAsciiImageConverter
import converters.image.gray.RGBImageToGrayscaleImageConverter
import converters.image.rgb.BufferedImageToRGBImageConverter
import exporters.image.AsciiImageExporter
import filters.image.{BrightnessGrayscaleImageFilter, BrightnessImageFilter, MixedImageFilter}
import loaders.image.file.RGBImageFileLoader
import operators.GrayscalePixelOperator

import java.io.{File, FileOutputStream}

object Main extends App {
  val appImage = new RGBImageFileLoader(
    new File("src/main/resources/images/linear_gradient.png"),
    new BufferedImageToRGBImageConverter).load();
  val grayscaleImage = new RGBImageToGrayscaleImageConverter().convert(appImage)

  val filter = new MixedImageFilter(
    List(
      new BrightnessGrayscaleImageFilter(10),
      new BrightnessGrayscaleImageFilter(10),
      new BrightnessGrayscaleImageFilter(10)))
  val filteredImage = filter.applyFilter(grayscaleImage)

  val asciiImage = new BourkeGrayscaleImageToAsciiAsciiImageConverter()
    .convert(filteredImage)
  new AsciiImageExporter(new FileOutputStream("out/image.txt"))
    .export(asciiImage)
}
