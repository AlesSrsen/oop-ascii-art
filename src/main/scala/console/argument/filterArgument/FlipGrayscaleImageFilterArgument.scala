package console.argument.filterArgument

import filters.image.ImageFilter
import filters.image.gray.flip.{XFlipGrayscaleImageFilter, YFlipGrayscaleImageFilter}
import models.image.GrayscaleImage

class FlipGrayscaleImageFilterArgument extends GrayscaleImageFilterArgument {
  override def parseTopAndPop(args: Args): (Boolean, Args) =
    if (args.nonEmpty && args.head == argumentName) {
      if (args.length < 2)
        throw new IllegalArgumentException("No direction to flip specified")
      if (args(1) != "x" && args(1) != "y")
        throw new IllegalArgumentException(
          "Incorrect direction to flip specified")
      (true, args.drop(2))
    } else
      (false, args)

  override def specification(): Seq[String] =
    Seq(argumentName, "x/y")

  override def argumentName: String = "--flip"

  override def getGrayscaleImageFilter(
    args: Args): (Option[ImageFilter[GrayscaleImage]], Args) = {
    val (isParsed, _) = parseTopAndPop(args)
    if (isParsed)
      if (args(1) == "x")
        (Some(new XFlipGrayscaleImageFilter), args.drop(2))
      else
        (Some(new YFlipGrayscaleImageFilter), args.drop(2))
    else
      (None, args)
  }
}
