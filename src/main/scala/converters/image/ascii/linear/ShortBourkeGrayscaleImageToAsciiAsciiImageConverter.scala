package converters.image.ascii.linear

class ShortBourkeGrayscaleImageToAsciiAsciiImageConverter
    extends LinearTableGrayscaleImageToAsciiImageConverter {
  override val table: Seq[Char] =
    " .:-=+*#%@".reverse.toSeq
}
