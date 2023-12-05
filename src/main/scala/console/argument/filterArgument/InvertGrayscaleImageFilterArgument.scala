package console.argument.filterArgument

import console.argument.ArgumentWithoutOptions
import filters.image.ImageFilter
import filters.image.gray.InvertGrayscaleImageFilter
import models.image.Image
import models.pixels.GrayscalePixel

class InvertGrayscaleImageFilterArgument
    extends GrayscaleImageFilterArgument
    with ArgumentWithoutOptions {
  override def argumentName: String = "--invert"

  override def getGrayscaleImageFilter(
    args: Args): (Option[ImageFilter[Image[GrayscalePixel]]], Args) =
    getResultArgumentWitoutOptions(
      args,
      Some(new InvertGrayscaleImageFilter)
    )
}
