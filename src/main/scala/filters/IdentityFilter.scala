package filters

class IdentityFilter[T] extends Filter[T] {
  def applyFilter(item: T): T = item
}
