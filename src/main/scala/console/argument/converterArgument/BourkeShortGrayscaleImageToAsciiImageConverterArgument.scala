package console.argument.converterArgument

import console.argument.ArgumentWithoutOptions
import converters.image.ImageToImageConverter
import converters.image.ascii.linear.ShortBourkeGrayscaleImageToAsciiAsciiImageConverter
import models.image.{AsciiImage, GrayscaleImage}

class BourkeShortGrayscaleImageToAsciiImageConverterArgument
    extends GrayscaleImageToAsciiImageConverterArgument
    with ArgumentWithoutOptions {
  override def argumentName: String = "--table-bourke-short"

  override def getGrayscaleImageToAsciiImageConverter(args: Args)
    : (Option[ImageToImageConverter[GrayscaleImage, AsciiImage]], Args) =
    getResultArgumentWitoutOptions(
      args,
      Some(new ShortBourkeGrayscaleImageToAsciiAsciiImageConverter))
}
