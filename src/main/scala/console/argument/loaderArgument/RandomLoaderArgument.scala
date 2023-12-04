package console.argument.loaderArgument
import console.argument.SingleArgument
import loaders.image.RGBImageLoader
import loaders.image.random.RGBImageRandomLoader

import java.util.Random

class RandomLoaderArgument extends LoaderArgument with SingleArgument {
  override def getRGBImageLoader(args: Args): (Option[RGBImageLoader], Args) =
    getResult(args, new RGBImageRandomLoader(new Random))

  override def argumentName: String = "--image-random"
}
