package console.argumentGroup.converterArgumentGroup

import console.argument.converterArgument.{BourkeGrayscaleImageToAsciiImageConverterArgument, GrayscaleImageToAsciiImageConverterArgument}
import console.argumentGroup.ArgumentGroup
import converters.image.ImageToImageConverter
import models.image.{AsciiImage, GrayscaleImage}

class ConverterArgumentGroup extends ArgumentGroup {

  override protected def arguments()
    : Seq[GrayscaleImageToAsciiImageConverterArgument] =
    Seq(
      new BourkeGrayscaleImageToAsciiImageConverterArgument,
      new BourkeGrayscaleImageToAsciiImageConverterArgument)

  def getGrayscaleImageFilter(args: Seq[String]): (
    Option[ImageToImageConverter[GrayscaleImage, AsciiImage]],
    Seq[String]) = {
    for (arg <- arguments()) {
      val (loader, newArgs) = arg.getGrayscaleImageToAsciiImageConverter(args)
      if (loader.isDefined) return (Some(loader.get), newArgs)
    }
    (None, args)
  }

}
