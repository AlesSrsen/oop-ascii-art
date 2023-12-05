package console.argumentGroup.loaderArgumentGroup

import console.argument.loaderArgument.{FileRGBImageLoaderArgument, RGBImageLoaderArgument, RandomRGBImageLoaderArgument}
import console.argumentGroup.ArgumentGroup
import loaders.image.RGBImageLoader

class RGBImageLoaderArgumentGroup extends ArgumentGroup {

  override protected def arguments(): Seq[RGBImageLoaderArgument] =
    Seq(new FileRGBImageLoaderArgument(), new RandomRGBImageLoaderArgument())

  def getLoader(args: Seq[String]): (Option[RGBImageLoader], Seq[String]) = {
    for (arg <- arguments()) {
      val (loader, newArgs) = arg.getRGBImageLoader(args)
      if (loader.isDefined) return (Some(loader.get), newArgs)
    }
    (None, args)
  }

}
