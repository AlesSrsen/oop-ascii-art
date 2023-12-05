package console.argument.converterArgument

import converters.image.ImageToImageConverter
import converters.image.ascii.linear.CustomTableGrayscaleImageToAsciiImageConverter
import models.image.Image
import models.pixels.{AsciiPixel, GrayscalePixel}

class CustomLinearGrayscaleImageToAsciiImageConverterArgument
    extends GrayscaleImageToAsciiImageConverterArgument {

  override def argumentName: String = "--table-custom"

  override def getGrayscaleImageToAsciiImageConverter(args: Args): (
    Option[ImageToImageConverter[Image[GrayscalePixel], Image[AsciiPixel]]],
    Args) =
    getResult(
      args,
      (argOptions) => {
        if (argOptions.isEmpty || argOptions.head.isEmpty)
          throw new IllegalArgumentException("No table provided")
        val table = argOptions.head.toSeq
        return (
          Some(new CustomTableGrayscaleImageToAsciiImageConverter(table)),
          argOptions.drop(1))
      }
    )

}
