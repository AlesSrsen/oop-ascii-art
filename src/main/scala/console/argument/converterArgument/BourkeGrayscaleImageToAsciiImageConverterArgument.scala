package console.argument.converterArgument

import console.argument.ArgumentWithoutOptions
import converters.image.ImageToImageConverter
import converters.image.ascii.linear.BourkeGrayscaleImageToAsciiAsciiImageConverter
import models.image.{AsciiImage, GrayscaleImage}

class BourkeGrayscaleImageToAsciiImageConverterArgument
    extends GrayscaleImageToAsciiImageConverterArgument
    with ArgumentWithoutOptions {

  override def argumentName: String = "--table-bourke"

  override def getGrayscaleImageToAsciiImageConverter(args: Args)
    : (Option[ImageToImageConverter[GrayscaleImage, AsciiImage]], Args) =
    getResultArgumentWitoutOptions(
      args,
      Some(new BourkeGrayscaleImageToAsciiAsciiImageConverter))

}
