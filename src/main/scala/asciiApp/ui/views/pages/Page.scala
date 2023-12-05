package asciiApp.ui.views.pages

trait Page[T] {
  def render(): T
}
