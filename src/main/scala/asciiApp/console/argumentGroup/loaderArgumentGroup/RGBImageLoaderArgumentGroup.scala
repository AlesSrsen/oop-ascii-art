package asciiApp.console.argumentGroup.loaderArgumentGroup

import asciiApp.console.argument.loaderArgument.{FileRGBImageLoaderArgument, RGBImageLoaderArgument, RandomRGBImageLoaderArgument}
import asciiApp.console.argumentGroup.ArgumentGroup
import loaders.image.RGBImageLoader

class RGBImageLoaderArgumentGroup extends ArgumentGroup[RGBImageLoader] {

  override protected def arguments(): Seq[RGBImageLoaderArgument] =
    Seq(new FileRGBImageLoaderArgument(), new RandomRGBImageLoaderArgument())
}
