package loaders

/**
 * A loader is a class that loads a resource.
 * @tparam T Resource
 */
trait Loader[T] {

  /**
   * Loads a resource
   * @return Resource
   */
  def load(): T
}
