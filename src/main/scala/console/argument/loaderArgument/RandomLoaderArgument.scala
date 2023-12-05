package console.argument.loaderArgument
import console.argument.ArgumentWithoutOptions
import loaders.image.RGBImageLoader
import loaders.image.random.RGBImageRandomLoader

import scala.util.Random

class RandomLoaderArgument extends LoaderArgument with ArgumentWithoutOptions {
  override def getRGBImageLoader(args: Args): (Option[RGBImageLoader], Args) =
    getResultArgumentWitoutOptions(
      args,
      Some(new RGBImageRandomLoader(new Random)))

  override def argumentName: String = "--image-random"
}
