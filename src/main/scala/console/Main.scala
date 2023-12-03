package console

import converters.image.ascii.linear.BourkeGrayscaleImageToAsciiAsciiImageConverter
import converters.image.gray.RGBImageToGrayscaleImageConverter
import converters.image.rgb.BufferedImageToRGBImageConverter
import exporters.image.AsciiImageExporter
import filters.image.gray.flip.{XFlipGrayscaleImageFilter, YFlipGrayscaleImageFilter}
import filters.image.MixedImageFilter
import filters.image.gray.BrightnessGrayscaleImageFilter
import loaders.image.file.RGBImageFileLoader

import java.io.{File, FileOutputStream}

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
    ))
  val filteredImage = filter.applyFilter(grayscaleImage)

  val asciiImage = new BourkeGrayscaleImageToAsciiAsciiImageConverter()
    .convert(filteredImage)
  new AsciiImageExporter(new FileOutputStream("out/image.txt"))
    .export(asciiImage)
}
