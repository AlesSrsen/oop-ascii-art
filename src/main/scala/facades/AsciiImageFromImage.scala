package facades

import converters.image.ImageToImageConverter
import converters.image.gray.RGBImageToGrayscaleImageConverter
import exporters.image.ImageExporter
import filters.image.ImageFilter
import loaders.image.RGBImageLoader
import models.image.Image
import models.pixels.{AsciiPixel, GrayscalePixel}

class AsciiImageFromImage {
  def createAsciiImageFromImage(
    loader: RGBImageLoader,
    filters: Iterable[ImageFilter[Image[GrayscalePixel]]],
    converter: ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]],
    exporters: Iterable[ImageExporter[Image[AsciiPixel]]]): Unit = {
    val image = loader.load()
    val grayscaleImage = new RGBImageToGrayscaleImageConverter().convert(image)

    val filteredImage = filters.foldLeft(grayscaleImage)((image, filter) =>
      filter.applyFilter(image))

    val asciiImage = converter
      .convert(filteredImage)

    exporters.foreach(exporter => exporter.export(asciiImage))
  }
}
