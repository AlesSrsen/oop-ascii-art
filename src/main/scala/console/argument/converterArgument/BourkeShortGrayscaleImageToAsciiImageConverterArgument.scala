package console.argument.converterArgument

import console.argument.SingleArgument
import converters.image.ImageToImageConverter
import converters.image.ascii.linear.ShortBourkeGrayscaleImageToAsciiAsciiImageConverter
import models.image.{AsciiImage, GrayscaleImage}

class BourkeShortGrayscaleImageToAsciiImageConverterArgument
    extends GrayscaleImageToAsciiImageConverterArgument
    with SingleArgument {
  override def argumentName: String = "--table-bourke-short"

  override def getGrayscaleImageToAsciiImageConverter(args: Args)
    : (Option[ImageToImageConverter[GrayscaleImage, AsciiImage]], Args) =
    getResult(args, new ShortBourkeGrayscaleImageToAsciiAsciiImageConverter)
}
