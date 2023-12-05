package console.argument.converterArgument

import console.argument.ArgumentWithoutOptions
import converters.image.ImageToImageConverter
import converters.image.ascii.linear.BourkeGrayscaleImageToAsciiAsciiImageConverter
import models.image.Image
import models.pixels.{AsciiPixel, GrayscalePixel}

class BourkeGrayscaleImageToAsciiImageConverterArgument
    extends GrayscaleImageToAsciiImageConverterArgument
    with ArgumentWithoutOptions {

  override def argumentName: String = "--table-bourke"

  override def getGrayscaleImageToAsciiImageConverter(args: Args): (
    Option[ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]],
    Args) =
    getResultArgumentWitoutOptions(
      args,
      Some(new BourkeGrayscaleImageToAsciiAsciiImageConverter))

}
