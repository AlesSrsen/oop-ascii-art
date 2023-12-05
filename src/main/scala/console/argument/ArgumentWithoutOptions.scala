package console.argument

trait ArgumentWithoutOptions[T] extends Argument[T] {
  override protected def argOptionsReducer(
                                            argumentOptions: Seq[String]): (T, Args) = (createInstance, argumentOptions)

  protected def createInstance: T
}
