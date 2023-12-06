package exporters

/**
 * Export object to some format
 * @tparam T type of object to export
 */
trait Exporter[T] {
  def export(item: T): Unit
}
