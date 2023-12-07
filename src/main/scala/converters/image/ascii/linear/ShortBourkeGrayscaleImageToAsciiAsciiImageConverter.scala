package converters.image.ascii.linear

/**
 * Short Bourke grayscale image to ASCII converter.
 * Mapping adapted from
 * @see [[https://paulbourke.net/dataformats/asciiart/]]
 */
class ShortBourkeGrayscaleImageToAsciiAsciiImageConverter
    extends LinearTableGrayscaleImageToAsciiImageConverter {
  override val table: Seq[Char] =
    "@%#*+=:-. ".toIndexedSeq
}
