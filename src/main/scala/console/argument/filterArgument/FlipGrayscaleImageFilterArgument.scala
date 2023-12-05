package console.argument.filterArgument

import filters.image.ImageFilter
import filters.image.generic.flip.{XFlipImageFilter, YFlipImageFilter}
import models.image.Image
import models.pixels.GrayscalePixel

class FlipGrayscaleImageFilterArgument extends GrayscaleImageFilterArgument {
  override def specification(): Seq[String] =
    Seq(argumentName, "x/y")

  override def argumentName: String = "--flip"

  override def getGrayscaleImageFilter(
    args: Args): (Option[ImageFilter[Image[GrayscalePixel]]], Args) =
    getResult(
      args,
      (otherArgs: Args) => {
        if (otherArgs.length < 1)
          throw new IllegalArgumentException("No flip direction specified")
        if (otherArgs.head != "x" && otherArgs.head != "y")
          throw new IllegalArgumentException("Invalid flip direction")
        if (otherArgs.head == "x")
          return (Some(new XFlipImageFilter()), otherArgs.drop(1))
        else
          return (Some(new YFlipImageFilter()), otherArgs.drop(1))
      }
    )
}
