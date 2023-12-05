package console.argument.converterArgument

import console.argument.Argument
import converters.image.ImageToImageConverter
import models.image.Image
import models.pixels.{AsciiPixel, GrayscalePixel}

trait GrayscaleImageToAsciiImageConverterArgument
    extends Argument[
      ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]] {}
