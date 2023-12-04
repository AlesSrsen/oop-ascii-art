package console.argument

trait SingleArgument extends Argument {
  override def parseTopAndPop(args: Args): (Boolean, Args) =
    if (args.nonEmpty && args.head == argumentName)
      (true, args.drop(1))
    else
      (false, args)

  override def specification(): Seq[String] = Seq(argumentName)

  def getResult[T](args: Args, result: T): (Option[T], Args) = {
    val (isParsed, _) = parseTopAndPop(args)
    if (isParsed)
      (Some(result), args.drop(1))
    else
      (None, args)
  }
}
