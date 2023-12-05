package console.argument.converterArgument

import console.argument.ArgumentWithoutOptions
import converters.image.ImageToImageConverter
import converters.image.ascii.nonlinear.OutliersNonlinearGrayscaleImageToAsciiImageConverter
import models.image.Image
import models.pixels.{AsciiPixel, GrayscalePixel}

class OutliersNonlinearGrayscaleImageToAsciiImageConverterArgument
    extends GrayscaleImageToAsciiImageConverterArgument
    with ArgumentWithoutOptions {

  override def argumentName: String = "--nonlinear-outliers"

  override def getGrayscaleImageToAsciiImageConverter(args: Args): (
    Option[ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]],
    Args) =
    getResultArgumentWitoutOptions(
      args,
      Some(new OutliersNonlinearGrayscaleImageToAsciiImageConverter))

}
