package console.argument.converterArgument

import converters.image.ImageToImageConverter
import converters.image.ascii.linear.BourkeGrayscaleImageToAsciiAsciiImageConverter
import models.image.{AsciiImage, GrayscaleImage}

class BourkeGrayscaleImageToAsciiImageConverterArgument
    extends GrayscaleImageToAsciiImageConverterArgument {

  override def argumentName: String = "--table-bourke"

  override def getGrayscaleImageToAsciiImageConverter(args: Args)
    : (Option[ImageToImageConverter[GrayscaleImage, AsciiImage]], Args) =
    getResult(args, Some(new BourkeGrayscaleImageToAsciiAsciiImageConverter))

}
