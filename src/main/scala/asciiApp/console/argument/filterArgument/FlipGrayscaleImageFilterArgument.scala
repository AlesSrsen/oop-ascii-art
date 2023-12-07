package asciiApp.console.argument.filterArgument

import asciiApp.console.exceptions.{InvalidArgumentOptionException, MissingArgumentOptionException}
import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter
import filters.image.generic.flip.{XFlipImageFilter, YFlipImageFilter}

class FlipGrayscaleImageFilterArgument extends GrayscaleImageFilterArgument {
  override def specification(): Seq[String] =
    super.specification().appended("<x/y>")

  override def argumentName: String = "--flip"

  override protected def argOptionsReducer(argumentOptions: Seq[String])
    : (ImageFilter[Image[GrayscalePixel]], Args) = {
    if (argumentOptions.length < 1)
      throw new MissingArgumentOptionException("No flip direction specified")
    argumentOptions.head match {
      case "x" => (new XFlipImageFilter(), argumentOptions.drop(1))
      case "y" => (new YFlipImageFilter(), argumentOptions.drop(1))
      case _ =>
        throw new InvalidArgumentOptionException(
          "Invalid flip direction: " + argumentOptions.head)
    }
  }
}
