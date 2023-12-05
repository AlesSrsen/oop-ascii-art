package console.argument.converterArgument

import console.argument.ArgumentWithoutOptions
import converters.image.ImageToImageConverter
import converters.image.ascii.linear.BourkeGrayscaleImageToAsciiAsciiImageConverter
import models.image.Image
import models.pixels.{AsciiPixel, GrayscalePixel}

class BourkeGrayscaleImageToAsciiImageConverterArgument
    extends GrayscaleImageToAsciiImageConverterArgument
    with ArgumentWithoutOptions[
      ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]] {

  override def argumentName: String = "--table-bourke"

  override protected def createInstance
    : ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]] =
    new BourkeGrayscaleImageToAsciiAsciiImageConverter
}
