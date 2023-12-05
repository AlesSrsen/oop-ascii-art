package console.argument.loaderArgument

import console.argument.Argument
import loaders.image.RGBImageLoader

trait RGBImageLoaderArgument extends Argument {
  def getRGBImageLoader(args: Args): (Option[RGBImageLoader], Args)
}
