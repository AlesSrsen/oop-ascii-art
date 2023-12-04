package console.argument.filterArgument

import filters.image.ImageFilter
import filters.image.gray.BrightnessGrayscaleImageFilter
import models.image.GrayscaleImage

class BrightnessImageFilterArgument extends GrayscaleImageFilterArgument {
  override def parseTopAndPop(args: Args): (Boolean, Args) =
    if (args.nonEmpty && args.head == argumentName) {
      if (args.length < 2)
        throw new IllegalArgumentException("No brightness amount specified")
      args(1).toIntOption match {
        case Some(_) => (true, args.drop(2))
        case None =>
          throw new IllegalArgumentException(
            "Brightness amount is not a number")
      }
    } else
      (false, args)

  override def specification(): Seq[String] =
    Seq(argumentName, "-255/+255")

  override def argumentName: String = "--brightness"

  override def getGrayscaleImageFilter(
    args: Args): (Option[ImageFilter[GrayscaleImage]], Args) = {
    val (isParsed, _) = parseTopAndPop(args)
    if (isParsed)
      (Some(new BrightnessGrayscaleImageFilter(args(1).toInt)), args.drop(2))
    else
      (None, args)
  }
}
