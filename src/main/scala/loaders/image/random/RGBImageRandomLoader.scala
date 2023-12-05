package loaders.image.random

import asciiApp.models.grid.PixelGrid
import asciiApp.models.image.Image
import asciiApp.models.pixels.RGBPixel
import loaders.RandomLoader
import loaders.image.RGBImageLoader

import scala.collection.mutable
import scala.util.Random

/**
 * Used to load a random RGB image
 * @param random Random number generator
 */
class RGBImageRandomLoader(random: Random)
    extends RandomLoader[Image[RGBPixel]]
    with RGBImageLoader {

  /**
   * Loads an RGB image with random dimensions and pixels
   * @return Resource
   */
  override def load(): Image[RGBPixel] = {
    val width = random.between(1, 1000)
    val height = random.between(1, 1000)
    val pixels =
      mutable.ArraySeq
        .fill(height)(mutable.ArraySeq.fill(width)(randomPixel()).toSeq)
        .toSeq
    new Image(new PixelGrid(pixels))
  }

  /**
   * Generates a random pixel
   * @return Random RGBPixel
   */
  private def randomPixel(): RGBPixel =
    new RGBPixel(
      random.between(0, 256),
      random.between(0, 256),
      random.between(0, 256))
}
