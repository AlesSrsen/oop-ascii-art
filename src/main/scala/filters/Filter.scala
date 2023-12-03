package filters

trait Filter[T] {
  def applyFilter(item: T): T
}
