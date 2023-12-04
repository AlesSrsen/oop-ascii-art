package converters.image.ascii.nonlinear
import scala.collection.SortedMap

class OutliersNonlinearGrayscaleImageToAsciiImageConverter
    extends NonlinearGrayscaleImageToAsciiImageConverter {
  override def characterMapping: SortedMap[Int, Char] = SortedMap(
    0 -> '@',
    5 -> ' ',
    250 -> '*'
  )
}
