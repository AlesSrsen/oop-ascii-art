package asciiApp.console.argumentGroup.filterArgumentGroup

import asciiApp.console.argument.filterArgument.{
  BrightnessGrayscaleImageFilterArgument,
  FlipGrayscaleImageFilterArgument,
  GrayscaleImageFilterArgument,
  InvertGrayscaleImageFilterArgument
}
import asciiApp.console.argumentGroup.ArgumentGroup
import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter

class GrayscaleImageFilterArgumentGroup
    extends ArgumentGroup[ImageFilter[Image[GrayscalePixel]]](
      Seq(
        new FlipGrayscaleImageFilterArgument,
        new BrightnessGrayscaleImageFilterArgument,
        new InvertGrayscaleImageFilterArgument)) {}
