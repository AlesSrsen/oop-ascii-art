package console.argument.converterArgument

import console.argument.SingleArgument
import converters.image.ImageToImageConverter
import converters.image.ascii.linear.BourkeGrayscaleImageToAsciiAsciiImageConverter
import models.image.{AsciiImage, GrayscaleImage}

class BourkeGrayscaleImageToAsciiImageConverterArgument
    extends GrayscaleImageToAsciiImageConverterArgument
    with SingleArgument {

  override def argumentName: String = "--table-bourke"

  override def getGrayscaleImageToAsciiImageConverter(args: Args)
    : (Option[ImageToImageConverter[GrayscaleImage, AsciiImage]], Args) =
    getResult(args, new BourkeGrayscaleImageToAsciiAsciiImageConverter)

}
