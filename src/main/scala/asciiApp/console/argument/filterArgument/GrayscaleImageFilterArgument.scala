package asciiApp.console.argument.filterArgument

import asciiApp.console.argument.Argument
import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter

trait GrayscaleImageFilterArgument
    extends Argument[ImageFilter[Image[GrayscalePixel]]] {}
