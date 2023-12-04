package console.argument.filterArgument

import console.argument.Argument
import filters.image.ImageFilter
import models.image.GrayscaleImage

trait GrayscaleImageFilterArgument extends Argument {
  def getGrayscaleImageFilter(
    args: Args): (Option[ImageFilter[GrayscaleImage]], Args)

}
