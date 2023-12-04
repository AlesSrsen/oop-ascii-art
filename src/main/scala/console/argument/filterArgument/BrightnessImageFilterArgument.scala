package console.argument.filterArgument

import filters.image.ImageFilter
import filters.image.gray.BrightnessGrayscaleImageFilter
import models.image.GrayscaleImage

class BrightnessImageFilterArgument extends GrayscaleImageFilterArgument {
  override def parseTopAndPop(args: Args): (Boolean, Args) =
    parseTopAndPop(
      args,
      (otherArgs: Args) => {
        if (otherArgs.length < 1)
          throw new IllegalArgumentException("No brightness amount specified")
        otherArgs.head.toIntOption match {
          case Some(_) => (true, otherArgs.drop(1))
          case None =>
            throw new IllegalArgumentException(
              "Brightness amount is not a number")
        }
      }
    )

  override def specification(): Seq[String] =
    Seq(argumentName, "-255/+255")

  override def argumentName: String = "--brightness"

  override def getGrayscaleImageFilter(
    args: Args): (Option[ImageFilter[GrayscaleImage]], Args) =
    getResult(
      args,
      (otherArgs: Args) =>
        (
          Some(new BrightnessGrayscaleImageFilter(otherArgs.head.toInt)),
          otherArgs.drop(1)))
}
