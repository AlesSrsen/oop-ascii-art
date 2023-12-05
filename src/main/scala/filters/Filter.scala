package filters

/**
 * Filter makes changes on the given item.
 * @tparam T the type of the item to be filtered.
 */
trait Filter[T] {

  /**
   * Applies the filter on the given item.
   * @param item the item to be filtered.
   * @return the filtered item.
   */
  def applyFilter(item: T): T
}
