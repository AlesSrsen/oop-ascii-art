package asciiApp.console.argument.converterArgument

import asciiApp.console.argument.ArgumentWithoutOptions
import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter
import converters.image.ascii.nonlinear.DefaultNonlinearGrayscaleImageToAsciiImageConverter

class DefaultNonlinearGrayscaleImageToAsciiImageConverterArgument
    extends GrayscaleImageToAsciiImageConverterArgument
    with ArgumentWithoutOptions[
      ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]] {

  override def argumentName: String = "--nonlinear-default"

  override protected def createInstance()
    : ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]] =
    new DefaultNonlinearGrayscaleImageToAsciiImageConverter
}
