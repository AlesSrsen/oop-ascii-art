package console.argument.filterArgument

import console.argument.ArgumentWithoutOptions
import filters.image.ImageFilter
import filters.image.gray.InvertGrayscaleImageFilter
import models.image.GrayscaleImage

class InvertGrayscaleImageFilterArgument
    extends GrayscaleImageFilterArgument
    with ArgumentWithoutOptions {
  override def argumentName: String = "--invert"

  override def getGrayscaleImageFilter(
    args: Args): (Option[ImageFilter[GrayscaleImage]], Args) =
    getResultArgumentWitoutOptions(
      args,
      Some(new InvertGrayscaleImageFilter)
    )
}
