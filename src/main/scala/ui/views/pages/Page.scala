package ui.views.pages

trait Page[T] {
  def render(): T
}
