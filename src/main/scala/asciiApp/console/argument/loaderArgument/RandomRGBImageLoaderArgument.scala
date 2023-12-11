package asciiApp.console.argument.loaderArgument

import asciiApp.console.argument.ArgumentWithoutOptions
import loaders.image.RGBImageLoader
import loaders.image.random.RGBImageRandomLoader

import scala.util.Random

/**
 * Argument for loading random image.
 */
class RandomRGBImageLoaderArgument
    extends RGBImageLoaderArgument
    with ArgumentWithoutOptions[RGBImageLoader] {

  override def argumentName: String = "--image-random"

  override protected def createInstance(): RGBImageLoader =
    new RGBImageRandomLoader(new Random)
}
