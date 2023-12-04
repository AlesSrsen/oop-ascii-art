package console.argument

trait Argument {
  def argumentName: String

  def parseTopAndPop(args: Args): (Boolean, Args) =
    parseTopAndPop(args, (rest) => (true, rest))

  def specification(): Seq[String] = Seq(argumentName)
  protected def parseTopAndPop(
    args: Args,
    reducer: Seq[String] => (Boolean, Args)): (Boolean, Args) =
    if (args.nonEmpty && args.head == argumentName)
      reducer(args.drop(1))
    else
      (false, args)

  protected def getResult[T](
    args: Args,
    reducer: Seq[String] => (Option[T], Seq[String])): (Option[T], Args) = {
    val (isParsed, _) = parseTopAndPop(args)
    if (isParsed)
      reducer(args.drop(1))
    else
      (None, args)
  }

  protected def getResult[T](
    args: Args,
    instanceOption: Option[T]): (Option[T], Args) =
    getResult(args, rest => (instanceOption, rest))

  type Args = Seq[String]
}
