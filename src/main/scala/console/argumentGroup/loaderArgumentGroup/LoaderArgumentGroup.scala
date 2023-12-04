package console.argumentGroup.loaderArgumentGroup

import console.argument.loaderArgument.{FileLoaderArgument, LoaderArgument, RandomLoaderArgument}
import console.argumentGroup.ArgumentGroup
import loaders.image.RGBImageLoader

class LoaderArgumentGroup extends ArgumentGroup {

  override protected def arguments(): Seq[LoaderArgument] =
    Seq(new FileLoaderArgument(), new RandomLoaderArgument())

  def getLoader(args: Seq[String]): (Option[RGBImageLoader], Seq[String]) = {
    for (arg <- arguments()) {
      val (loader, newArgs) = arg.getRGBImageLoader(args)
      if (loader.isDefined) return (Some(loader.get), newArgs)
    }
    (None, args)
  }

}
