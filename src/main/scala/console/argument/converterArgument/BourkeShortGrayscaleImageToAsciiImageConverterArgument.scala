package console.argument.converterArgument

import console.argument.ArgumentWithoutOptions
import converters.image.ImageToImageConverter
import converters.image.ascii.linear.ShortBourkeGrayscaleImageToAsciiAsciiImageConverter
import models.image.Image
import models.pixels.{AsciiPixel, GrayscalePixel}

class BourkeShortGrayscaleImageToAsciiImageConverterArgument
    extends GrayscaleImageToAsciiImageConverterArgument
    with ArgumentWithoutOptions[
      ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]] {
  override def argumentName: String = "--table-bourke-short"

  override protected def createInstance
    : ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]] =
    new ShortBourkeGrayscaleImageToAsciiAsciiImageConverter
}
