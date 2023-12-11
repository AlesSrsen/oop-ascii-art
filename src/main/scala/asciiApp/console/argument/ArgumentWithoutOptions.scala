package asciiApp.console.argument

/**
 * Argument without options.
 * @tparam T type of the result of the argument
 */
trait ArgumentWithoutOptions[T] extends Argument[T] {
  override protected def argOptionsReducer(
    argumentOptions: Seq[String]): (T, Args) = (createInstance(), argumentOptions)

  /**
   * Argument without options should create an instance of the result type, since they do not do any additional parsing
   * @return Instance of the result type
   */
  protected def createInstance(): T
}
