package asciiApp.console.argument

/**
 * Argument trait
 * @tparam T type of the result of the argument
 */
trait Argument[T] {
  type Args = Seq[String]

  /**
   * Main name of the argument
   */
  def argumentName: String

  /**
   * Specification of the argument
   * @return Specification of the argument
   */
  def specification(): Seq[String] = argumentAliases

  /**
   * All names under which the argument can be called
   */
  private def argumentAliases: Seq[String] =
    Seq(argumentName).concat(aliases)

  /**
   * Aliases of the argument
   * Argument can be aliased, for example --image-input is also aliased as -i
   */
  def aliases: Seq[String] = Seq.empty

  /**
   * Gets the result of parsing the arguments passed to the function
   * @param args Arguments to parse
   * @return Parsing result and unparsed arguments
   */
  def getResult(args: Args): (Option[T], Args) =
    if (args.nonEmpty && argumentAliases.contains(args.head)) {
      val (instance, restOfArgs) = argOptionsReducer(args.drop(1))
      (Some(instance), restOfArgs)
    } else
      (None, args)

  /**
   * Function to be defined in the child class
   * @param argumentOptions Rest of the arguments after the argument name
   * @return Parsing result and unparsed arguments
   */
  protected def argOptionsReducer(argumentOptions: Seq[String]): (T, Args)
}
