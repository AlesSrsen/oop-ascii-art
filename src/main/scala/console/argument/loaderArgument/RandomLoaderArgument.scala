package console.argument.loaderArgument
import loaders.image.RGBImageLoader
import loaders.image.random.RGBImageRandomLoader

import java.util.Random

class RandomLoaderArgument extends LoaderArgument {
  override def getRGBImageLoader(args: Args): (Option[RGBImageLoader], Args) =
    getResult(args, Some(new RGBImageRandomLoader(new Random)))

  override def argumentName: String = "--image-random"
}
