package asciiApp.console.argument.filterArgument
import asciiApp.console.exceptions.{InvalidArgumentOptionException, MissingArgumentOptionException}
import asciiApp.models.image.Image
import asciiApp.models.pixels.GrayscalePixel
import filters.image.ImageFilter
import filters.image.generic.RotateImageFilter

class RotateGrayscaleImageFilterArgument extends GrayscaleImageFilterArgument {

  /**
   * Main name of the argument
   */
  override def argumentName: String = "--rotate"

  override def specification(): Seq[String] =
    super.specification().concat(Seq("<-360/+360>", "Must be a multiple of 90"))

  /**
   * Function to be defined in the child class
   *
   * @param argumentOptions Rest of the arguments after the argument name
   * @return Parsing result and unparsed arguments
   */
  override protected def argOptionsReducer(argumentOptions: Seq[String])
    : (ImageFilter[Image[GrayscalePixel]], Args) = {
    if (argumentOptions.length < 1)
      throw new MissingArgumentOptionException("No rotation amount specified")
    argumentOptions.head.toIntOption match {
      case Some(amount) =>
        if (amount % 90 != 0 || amount < -360 || amount > 360)
          throw new InvalidArgumentOptionException(
            "Invalid rotation amount: " + argumentOptions.head,
            new NumberFormatException())
        (
          new RotateImageFilter(amount),
          argumentOptions.drop(1)
        )

      case None =>
        throw new InvalidArgumentOptionException(
          "Invalid rotation amount: " + argumentOptions.head,
          new NumberFormatException())
    }
  }
}
