package console.argument

trait Argument {
  def argumentName: String
  def parseTopAndPop(args: Args): (Boolean, Args)
  def specification(): Seq[String]

  type Args = Seq[String]
}
