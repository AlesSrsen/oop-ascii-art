package console.argument.converterArgument

import console.exceptions.MissingArgumentOptionException
import converters.image.ImageToImageConverter
import converters.image.ascii.linear.CustomTableGrayscaleImageToAsciiImageConverter
import models.image.Image
import models.pixels.{AsciiPixel, GrayscalePixel}

class CustomLinearGrayscaleImageToAsciiImageConverterArgument
    extends GrayscaleImageToAsciiImageConverterArgument {

  override def specification(): Seq[String] =
    super.specification().appended("<table>")

  override def argumentName: String = "--table-custom"

  override protected def argOptionsReducer(argumentOptions: Seq[String]): (
    ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]],
    Args) = {
    if (argumentOptions.isEmpty || argumentOptions.head.isEmpty)
      throw new MissingArgumentOptionException(
        "No table provided for: " + argumentName)
    val table = argumentOptions.head.toSeq
    (
      new CustomTableGrayscaleImageToAsciiImageConverter(table),
      argumentOptions.drop(1)
    )
  }
}
