package asciiApp.console.argument.converterArgument

import asciiApp.console.argument.Argument
import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter

trait GrayscaleImageToAsciiImageConverterArgument
    extends Argument[
      ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]] {}
