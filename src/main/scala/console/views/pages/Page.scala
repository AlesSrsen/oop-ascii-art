package console.views.pages

trait Page[T] {
  def render(): T
}
