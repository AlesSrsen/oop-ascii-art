package console.argument

trait Argument[+T] {
  def argumentName: String

  def aliases: Seq[String] = Seq.empty

  private def argumentAliases: Seq[String] =
    Seq(argumentName).concat(aliases)

  def specification(): Seq[String] = argumentAliases

  def getResult(args: Args): (Option[T], Args) =
    if (args.nonEmpty && argumentName.contains(args.head)) {
      val (instance, restOfArgs) = argOptionsReducer(args.drop(1))
      (Some(instance), restOfArgs)
    } else
      (None, args)

  protected def argOptionsReducer(argumentOptions: Seq[String]): (T, Args)

  type Args = Seq[String]
}
