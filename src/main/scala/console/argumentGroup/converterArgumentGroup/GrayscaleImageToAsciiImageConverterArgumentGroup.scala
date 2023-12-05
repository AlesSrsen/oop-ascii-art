package console.argumentGroup.converterArgumentGroup

import console.argument.converterArgument._
import console.argumentGroup.ArgumentGroup
import converters.image.ImageToImageConverter
import models.image.Image
import models.pixels.{AsciiPixel, GrayscalePixel}

class GrayscaleImageToAsciiImageConverterArgumentGroup
    extends ArgumentGroup[
      ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]] {

  override protected def arguments()
    : Seq[GrayscaleImageToAsciiImageConverterArgument] =
    Seq(
      new BourkeGrayscaleImageToAsciiImageConverterArgument,
      new BourkeShortGrayscaleImageToAsciiImageConverterArgument,
      new DefaultNonlinearGrayscaleImageToAsciiImageConverterArgument,
      new OutliersNonlinearGrayscaleImageToAsciiImageConverterArgument,
      new CustomLinearGrayscaleImageToAsciiImageConverterArgument
    )
}
