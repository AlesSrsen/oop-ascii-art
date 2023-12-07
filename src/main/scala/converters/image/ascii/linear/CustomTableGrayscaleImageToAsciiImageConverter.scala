package converters.image.ascii.linear

/**
 * Custom table grayscale image to ASCII converter.
 * @param table user defined table
 */
class CustomTableGrayscaleImageToAsciiImageConverter(
  override val table: Seq[Char])
    extends LinearTableGrayscaleImageToAsciiImageConverter {}
