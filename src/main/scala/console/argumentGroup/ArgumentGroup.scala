package console.argumentGroup

import console.argument.Argument

trait ArgumentGroup {
  protected def arguments(): Seq[Argument]

  def parseTopAndPop(args: Seq[String]): (Boolean, Seq[String]) = {
    for (arg <- arguments()) {
      val (isValid, newArgs) = arg.parseTopAndPop(args)
      if (isValid) return (true, newArgs)
    }
    (false, args)
  }

  def groupSpecification(): Seq[Seq[String]] =
    for (arg <- arguments()) yield arg.specification()
}
