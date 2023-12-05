package console.argument.filterArgument

import console.argument.Argument
import filters.image.ImageFilter
import models.image.Image
import models.pixels.GrayscalePixel

trait GrayscaleImageFilterArgument
    extends Argument[ImageFilter[Image[GrayscalePixel]]] {}
