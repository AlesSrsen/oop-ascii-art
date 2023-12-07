package asciiApp.console.argumentGroup

import asciiApp.console.argument.Argument

abstract class ArgumentGroup[T] {
  private var _parsed: Boolean = false
  private var _parsingResult: Seq[T] = Seq.empty[T]

  def groupSpecification(): Seq[Seq[String]] =
    for (arg <- arguments()) yield arg.specification()

  private def tryParseTop(args: Seq[String]): (Option[T], Seq[String]) = {
    for (arg <- arguments()) {
      val (result, newArgs) = arg.getResult(args)
      if (result.isDefined) return (result, newArgs)
    }
    (None, args)
  }

  def parse(args: Seq[String]): Seq[String] = {
    if (_parsed)
      throw new IllegalStateException("This group has already been parsed")
    _parsed = true

    var unparsedArguments = Seq.empty[String]
    var argsToConsume = args

    while (argsToConsume.nonEmpty) {
      val (result, newArgs) = tryParseTop(argsToConsume)
      if (result.isDefined) {
        _parsingResult :+= result.get
        argsToConsume = newArgs
      } else {
        unparsedArguments :+= argsToConsume.head
        argsToConsume = argsToConsume.drop(1)
      }
    }

    unparsedArguments
  }

  def getParsingResult: Seq[T] = {
    if (!_parsed) throw new IllegalStateException("No arguments were parsed")
    _parsingResult
  }

  protected def arguments(): Seq[Argument[T]]
}
