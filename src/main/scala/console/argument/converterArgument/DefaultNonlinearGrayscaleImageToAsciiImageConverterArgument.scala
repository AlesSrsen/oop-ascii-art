package console.argument.converterArgument

import console.argument.ArgumentWithoutOptions
import converters.image.ImageToImageConverter
import converters.image.ascii.nonlinear.DefaultNonlinearGrayscaleImageToAsciiImageConverter
import models.image.Image
import models.pixels.{AsciiPixel, GrayscalePixel}

class DefaultNonlinearGrayscaleImageToAsciiImageConverterArgument
    extends GrayscaleImageToAsciiImageConverterArgument
    with ArgumentWithoutOptions[
      ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]] {

  override def argumentName: String = "--nonlinear-default"

  override protected def createInstance
    : ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]] =
    new DefaultNonlinearGrayscaleImageToAsciiImageConverter
}
