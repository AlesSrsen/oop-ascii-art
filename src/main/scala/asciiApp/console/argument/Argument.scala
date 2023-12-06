package asciiApp.console.argument

trait Argument[T] {
  type Args = Seq[String]

  def argumentName: String

  def specification(): Seq[String] = argumentAliases

  private def argumentAliases: Seq[String] =
    Seq(argumentName).concat(aliases)

  def aliases: Seq[String] = Seq.empty

  def getResult(args: Args): (Option[T], Args) =
    if (args.nonEmpty && argumentName.contains(args.head)) {
      val (instance, restOfArgs) = argOptionsReducer(args.drop(1))
      (Some(instance), restOfArgs)
    } else
      (None, args)

  protected def argOptionsReducer(argumentOptions: Seq[String]): (T, Args)
}
