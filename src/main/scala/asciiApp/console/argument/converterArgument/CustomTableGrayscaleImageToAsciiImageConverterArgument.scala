package asciiApp.console.argument.converterArgument

import asciiApp.console.exceptions.MissingArgumentOptionException
import asciiApp.models.image.Image
import asciiApp.models.pixels.{AsciiPixel, GrayscalePixel}
import converters.image.ImageToImageConverter
import converters.image.ascii.linear.CustomTableGrayscaleImageToAsciiImageConverter

class CustomTableGrayscaleImageToAsciiImageConverterArgument
    extends GrayscaleImageToAsciiImageConverterArgument {

  override def specification(): Seq[String] =
    super.specification().appended("<table>")

  override protected def argOptionsReducer(argumentOptions: Seq[String]): (
    ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]],
    Args) = {
    if (argumentOptions.isEmpty || argumentOptions.head.isEmpty)
      throw new MissingArgumentOptionException(
        "No table provided for: " + argumentName)
    val table = argumentOptions.head.toIndexedSeq
    (
      new CustomTableGrayscaleImageToAsciiImageConverter(table),
      argumentOptions.drop(1)
    )
  }

  override def argumentName: String = "--table-custom"
}
