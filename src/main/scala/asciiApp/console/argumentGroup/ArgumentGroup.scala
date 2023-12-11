package asciiApp.console.argumentGroup

import asciiApp.console.argument.Argument

/**
 * A group of arguments that can be parsed together
 * @param arguments Arguments in the group
 * @tparam T The type of the result of parsing the arguments
 */
abstract class ArgumentGroup[T](arguments: Seq[Argument[T]]) {
  private var _parsed: Boolean = false
  private var _parsingResult: Seq[T] = Seq.empty[T]

  /**
   * Returns the specification of the group
   * @return Specification of the group
   */
  def groupSpecification(): Seq[Seq[String]] =
    for (arg <- arguments) yield arg.specification()

  /**
   * Parses the arguments
   * Keeps the unparsed arguments whilst saving the parsing result
   * @param args Arguments to parse
   * @return Unparsed arguments
   */
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

  /**
   * Tries to parse the argument on top using the arguments in the group
   * @param args Arguments to parse
   * @return Parsing result and unparsed arguments
   */
  private def tryParseTop(args: Seq[String]): (Option[T], Seq[String]) = {
    for (arg <- arguments) {
      val (result, newArgs) = arg.getResult(args)
      if (result.isDefined) return (result, newArgs)
    }
    (None, args)
  }

  /**
   * Returns the parsing result
   * @return Parsing result
   */
  def getParsingResult: Seq[T] = {
    if (!_parsed) throw new IllegalStateException("No arguments were parsed")
    _parsingResult
  }

}
