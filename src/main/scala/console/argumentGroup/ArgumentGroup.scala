package console.argumentGroup

import console.argument.Argument

trait ArgumentGroup {
  protected def arguments(): Seq[Argument]

  def groupSpecification(): Seq[Seq[String]] =
    for (arg <- arguments()) yield arg.specification()
}
