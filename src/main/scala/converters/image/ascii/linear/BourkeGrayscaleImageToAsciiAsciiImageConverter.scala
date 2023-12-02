package converters.image.ascii.linear

class BourkeGrayscaleImageToAsciiAsciiImageConverter
    extends LinearTableGrayscaleImageToAsciiImageConverter {
  override val table: Seq[Char] =
    "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ".toSeq
}
