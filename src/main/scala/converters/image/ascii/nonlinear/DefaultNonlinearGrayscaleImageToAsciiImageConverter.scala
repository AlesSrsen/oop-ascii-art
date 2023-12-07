package converters.image.ascii.nonlinear
import scala.collection.SortedMap

/**
 * Made up mapping where middle levels of brightness are covered by ';'
 */
class DefaultNonlinearGrayscaleImageToAsciiImageConverter
    extends NonlinearGrayscaleImageToAsciiImageConverter {
  override val characterMapping: SortedMap[Int, Char] =
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
