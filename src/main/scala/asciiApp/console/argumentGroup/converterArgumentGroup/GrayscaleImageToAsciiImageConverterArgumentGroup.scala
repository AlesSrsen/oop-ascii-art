package asciiApp.console.argumentGroup.converterArgumentGroup

import asciiApp.console.argument.converterArgument._
import asciiApp.console.argumentGroup.ArgumentGroup
import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter

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
