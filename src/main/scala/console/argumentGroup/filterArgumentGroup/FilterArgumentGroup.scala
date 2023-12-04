package console.argumentGroup.filterArgumentGroup

import console.argument.filterArgument.{BrightnessImageFilterArgument, FlipGrayscaleImageFilterArgument, GrayscaleImageFilterArgument, InvertGrayscaleImageFilterArgument}
import console.argumentGroup.ArgumentGroup
import filters.image.ImageFilter
import models.image.GrayscaleImage

class FilterArgumentGroup extends ArgumentGroup {

  override protected def arguments(): Seq[GrayscaleImageFilterArgument] =
    Seq(
      new FlipGrayscaleImageFilterArgument,
      new BrightnessImageFilterArgument,
      new InvertGrayscaleImageFilterArgument)

  def getGrayscaleImageFilter(
    args: Seq[String]): (Option[ImageFilter[GrayscaleImage]], Seq[String]) = {
    for (arg <- arguments()) {
      val (loader, newArgs) = arg.getGrayscaleImageFilter(args)
      if (loader.isDefined) return (Some(loader.get), newArgs)
    }
    (None, args)
  }

}
