package asciiApp.console.argument.converterArgument

import asciiApp.console.argument.ArgumentWithoutOptions
import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter
import converters.image.ascii.linear.ShortBourkeGrayscaleImageToAsciiImageConverter

class ShortBourkeGrayscaleImageToAsciiImageConverterArgument
    extends GrayscaleImageToAsciiImageConverterArgument
    with ArgumentWithoutOptions[
      ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]] {
  override def argumentName: String = "--table-short-bourke"

  override protected def createInstance()
    : ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]] =
    new ShortBourkeGrayscaleImageToAsciiImageConverter
}
