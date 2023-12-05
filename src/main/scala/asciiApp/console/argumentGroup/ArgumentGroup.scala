package asciiApp.console.argumentGroup

import asciiApp.console.argument.Argument

trait ArgumentGroup[T] {
  def groupSpecification(): Seq[Seq[String]] =
    for (arg <- arguments()) yield arg.specification()

  def tryParseTop(args: Seq[String]): (Option[T], Seq[String]) = {
    for (arg <- arguments()) {
      val (loader, newArgs) = arg.getResult(args)
      if (loader.isDefined) return (loader, newArgs)
    }
    (None, args)
  }

  protected def arguments(): Seq[Argument[T]]
}
