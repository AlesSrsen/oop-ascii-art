package console.argument.converterArgument

import console.argument.Argument
import converters.image.ImageToImageConverter
import models.image.{AsciiImage, GrayscaleImage}

trait GrayscaleImageToAsciiImageConverterArgument extends Argument {
  def getGrayscaleImageToAsciiImageConverter(args: Args)
    : (Option[ImageToImageConverter[GrayscaleImage, AsciiImage]], Args)
}
