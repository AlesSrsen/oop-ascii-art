package console.argument

trait Argument[+T] {
  def argumentName: String
  def specification(): Seq[String] = Seq(argumentName)

  def getResult(args: Args): (Option[T], Args) =
    if (args.nonEmpty && args.head == argumentName) {
      val (instance, restOfArgs) = argOptionsReducer(args.drop(1))
      (Some(instance), restOfArgs)
    } else
      (None, args)

  protected def argOptionsReducer(argumentOptions: Seq[String]): (T, Args)

  type Args = Seq[String]
}
