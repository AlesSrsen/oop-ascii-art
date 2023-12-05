package filters

/**
 * IdentityFilter keeps the given item unchanged.
 * @tparam T the type of the item to be filtered.
 */
class IdentityFilter[T] extends Filter[T] {
  def applyFilter(item: T): T = item
}
