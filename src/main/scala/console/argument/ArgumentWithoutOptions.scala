package console.argument

trait ArgumentWithoutOptions extends Argument {
  protected def getResultArgumentWitoutOptions[T](
    args: Args,
    instanceOption: Option[T]): (Option[T], Args) =
    getResult(args, (rest) => (instanceOption, rest))
}
