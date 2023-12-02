package console

import converters.image.ascii.linear.BourkeGrayscaleImageToAsciiAsciiImageConverter
import converters.image.gray.RGBImageToGrayscaleImageConverter
import converters.image.rgb.BufferedImageToRGBImageConverter
import exporters.image.AsciiImageExporter
import loaders.image.file.RGBImageFileLoader

import java.io.FileOutputStream

object Main extends App {
  val appImage = new RGBImageFileLoader(
    "src/main/resources/images/linear_gradient.png",
    new BufferedImageToRGBImageConverter).load();
  val asciiImage = new BourkeGrayscaleImageToAsciiAsciiImageConverter()
    .convert(new RGBImageToGrayscaleImageConverter().convert(appImage))
  new AsciiImageExporter(
    new FileOutputStream("out/image.txt"))
    .export(asciiImage)
}
