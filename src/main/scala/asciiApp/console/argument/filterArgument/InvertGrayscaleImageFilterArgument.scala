package asciiApp.console.argument.filterArgument

import asciiApp.console.argument.ArgumentWithoutOptions
import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter
import filters.image.gray.InvertGrayscaleImageFilter

class InvertGrayscaleImageFilterArgument
    extends GrayscaleImageFilterArgument
    with ArgumentWithoutOptions[ImageFilter[Image[GrayscalePixel]]] {
  override def argumentName: String = "--invert"

  override protected def createInstance: ImageFilter[Image[GrayscalePixel]] =
    new InvertGrayscaleImageFilter
}
