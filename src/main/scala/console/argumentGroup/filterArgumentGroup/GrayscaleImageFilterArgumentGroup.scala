package console.argumentGroup.filterArgumentGroup

import console.argument.filterArgument.{BrightnessImageFilterArgument, FlipGrayscaleImageFilterArgument, GrayscaleImageFilterArgument, InvertGrayscaleImageFilterArgument}
import console.argumentGroup.ArgumentGroup
import filters.image.ImageFilter
import models.image.Image
import models.pixels.GrayscalePixel

class GrayscaleImageFilterArgumentGroup
    extends ArgumentGroup[ImageFilter[Image[GrayscalePixel]]] {

  override protected def arguments(): Seq[GrayscaleImageFilterArgument] =
    Seq(
      new FlipGrayscaleImageFilterArgument,
      new BrightnessImageFilterArgument,
      new InvertGrayscaleImageFilterArgument)

}
