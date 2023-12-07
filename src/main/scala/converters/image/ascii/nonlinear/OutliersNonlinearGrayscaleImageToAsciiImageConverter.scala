package converters.image.ascii.nonlinear
import scala.collection.SortedMap

/**
 * Made up mapping that maps
 * brightest 2% of pixels to '*'
 * darkest 2% of pixels to '@'
 * and the rest to ' '
 */
class OutliersNonlinearGrayscaleImageToAsciiImageConverter
    extends NonlinearGrayscaleImageToAsciiImageConverter {
  override val characterMapping: SortedMap[Int, Char] = SortedMap(
    0 -> '@',
    5 -> ' ',
    250 -> '*'
  )
}
