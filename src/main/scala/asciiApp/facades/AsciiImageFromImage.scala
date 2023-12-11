package asciiApp.facades

import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter
import converters.image.gray.RGBImageToGrayscaleImageConverter
import exporters.image.ImageExporter
import filters.image.ImageFilter
import loaders.image.RGBImageLoader

/**
 * Facade for creating an ASCII image from an RGB image.
 * This class orchestrates the loading of the image, applying filters, converting to ASCII, and exporting the ASCII image.
 */
class AsciiImageFromImage {

  /**
   * Creates an ASCII image from an RGB image
   * @param loader RGB image loader (Only one can be specified)
   * @param filters Filters to apply to the image. They are applied in the order they are specified
   * @param converter Converter to convert the image to ASCII (Only one can be specified)
   * @param exporters Exporters to export the ASCII image. Image is exported to all exporters specified in the order they are specified
   */
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
