package asciiApp.console.argumentGroup.filterArgumentGroup

import asciiApp.console.argument.filterArgument.{BrightnessImageFilterArgument, FlipGrayscaleImageFilterArgument, GrayscaleImageFilterArgument, InvertGrayscaleImageFilterArgument}
import asciiApp.console.argumentGroup.ArgumentGroup
import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter

class GrayscaleImageFilterArgumentGroup
    extends ArgumentGroup[ImageFilter[Image[GrayscalePixel]]] {

  override protected def arguments(): Seq[GrayscaleImageFilterArgument] =
    Seq(
      new FlipGrayscaleImageFilterArgument,
      new BrightnessImageFilterArgument,
      new InvertGrayscaleImageFilterArgument)

}
