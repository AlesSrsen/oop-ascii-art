package console.argument

trait Argument {
  def argumentName: String
  def specification(): Seq[String] = Seq(argumentName)

  protected def getResult[T](
    args: Args,
    argOptionsReducer: Args => (Option[T], Args)): (Option[T], Args) =
    if (args.nonEmpty && args.head == argumentName)
      argOptionsReducer(args.drop(1))
    else
      (None, args)

  type Args = Seq[String]
}
