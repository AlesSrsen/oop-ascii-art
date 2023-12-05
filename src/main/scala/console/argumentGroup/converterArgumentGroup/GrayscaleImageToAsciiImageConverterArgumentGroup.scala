package console.argumentGroup.converterArgumentGroup

import console.argument.converterArgument._
import console.argumentGroup.ArgumentGroup
import converters.image.ImageToImageConverter
import models.image.Image
import models.pixels.{AsciiPixel, GrayscalePixel}

class GrayscaleImageToAsciiImageConverterArgumentGroup extends ArgumentGroup {

  override protected def arguments()
    : Seq[GrayscaleImageToAsciiImageConverterArgument] =
    Seq(
      new BourkeGrayscaleImageToAsciiImageConverterArgument,
      new BourkeShortGrayscaleImageToAsciiImageConverterArgument,
      new DefaultNonlinearGrayscaleImageToAsciiImageConverterArgument,
      new OutliersNonlinearGrayscaleImageToAsciiImageConverterArgument,
      new CustomLinearGrayscaleImageToAsciiImageConverterArgument
    )

  def getGrayscaleImageFilter(args: Seq[String]): (
    Option[ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]],
    Seq[String]) = {
    for (arg <- arguments()) {
      val (loader, newArgs) = arg.getGrayscaleImageToAsciiImageConverter(args)
      if (loader.isDefined) return (Some(loader.get), newArgs)
    }
    (None, args)
  }

}
