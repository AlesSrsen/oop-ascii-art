package converters.image.ascii.linear

/**
 * Bourke grayscale image to ASCII converter.
 * Mapping adapted from
 * @see [[https://paulbourke.net/dataformats/asciiart/]]
 */
class BourkeGrayscaleImageToAsciiAsciiImageConverter
    extends LinearTableGrayscaleImageToAsciiImageConverter {
  override val table: Seq[Char] =
    "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ".toIndexedSeq
}
