package converters.image.ascii.nonlinear
import scala.collection.SortedMap

class DefaultNonlinearGrayscaleImageToAsciiImageConverter
    extends NonlinearGrayscaleImageToAsciiImageConverter {
  override def characterMapping: SortedMap[Int, Char] =
    SortedMap(
      0 -> '@',
      20 -> '$',
      22 -> '#',
      24 -> '*',
      26 -> '!',
      28 -> '=',
      30 -> ';',
      190 -> ':',
      250 -> '~',
      251 -> '-',
      252 -> ',',
      253 -> '.',
      254 -> ' '
    )
}
