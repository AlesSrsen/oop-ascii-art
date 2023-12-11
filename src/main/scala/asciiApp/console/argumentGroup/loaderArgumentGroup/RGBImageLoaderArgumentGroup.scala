package asciiApp.console.argumentGroup.loaderArgumentGroup

import asciiApp.console.argument.loaderArgument.{FileRGBImageLoaderArgument, RandomRGBImageLoaderArgument}
import asciiApp.console.argumentGroup.ArgumentGroup
import loaders.image.RGBImageLoader

class RGBImageLoaderArgumentGroup
    extends ArgumentGroup[RGBImageLoader](Seq(
      new FileRGBImageLoaderArgument(),
      new RandomRGBImageLoaderArgument())) {}
