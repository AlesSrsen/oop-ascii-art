package asciiApp.ui.views.pages

/**
 * Pages are used to render information to the user.
 * @tparam T The type of the rendered information.
 */
trait Page[T] {
  def render(): T
}
