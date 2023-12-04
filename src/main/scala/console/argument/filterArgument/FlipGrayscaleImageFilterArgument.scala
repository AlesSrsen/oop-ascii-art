package console.argument.filterArgument

import filters.image.ImageFilter
import filters.image.gray.flip.{XFlipGrayscaleImageFilter, YFlipGrayscaleImageFilter}
import models.image.GrayscaleImage

class FlipGrayscaleImageFilterArgument extends GrayscaleImageFilterArgument {
  override def parseTopAndPop(args: Args): (Boolean, Args) =
    parseTopAndPop(
      args,
      (otherArgs: Args) => {
        if (otherArgs.length < 1)
          throw new IllegalArgumentException("No flip direction specified")
        if (otherArgs.head != "x" && otherArgs.head != "y")
          throw new IllegalArgumentException("Invalid flip direction")
        (true, otherArgs.drop(1))
      }
    )

  override def specification(): Seq[String] =
    Seq(argumentName, "x/y")

  override def argumentName: String = "--flip"

  override def getGrayscaleImageFilter(
    args: Args): (Option[ImageFilter[GrayscaleImage]], Args) =
    getResult(
      args,
      (otherArgs: Args) =>
        (
          if (otherArgs.head == "x")
            Some(new XFlipGrayscaleImageFilter())
          else
            Some(new YFlipGrayscaleImageFilter()),
          otherArgs.drop(1)))
}
