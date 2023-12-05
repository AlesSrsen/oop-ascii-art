package console.argumentGroup

import console.argument.Argument

trait ArgumentGroup[T] {
  protected def arguments(): Seq[Argument[T]]

  def groupSpecification(): Seq[Seq[String]] =
    for (arg <- arguments()) yield arg.specification()

  def tryParseTop(args: Seq[String]): (Option[T], Seq[String]) = {
    for (arg <- arguments()) {
      val (loader, newArgs) = arg.getResult(args)
      if (loader.isDefined) return (loader, newArgs)
    }
    (None, args)
  }
}
