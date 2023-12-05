package console.argumentGroup.loaderArgumentGroup

import console.argument.loaderArgument.{FileRGBImageLoaderArgument, RGBImageLoaderArgument, RandomRGBImageLoaderArgument}
import console.argumentGroup.ArgumentGroup
import loaders.image.RGBImageLoader

class RGBImageLoaderArgumentGroup extends ArgumentGroup[RGBImageLoader] {

  override protected def arguments(): Seq[RGBImageLoaderArgument] =
    Seq(new FileRGBImageLoaderArgument(), new RandomRGBImageLoaderArgument())
}
