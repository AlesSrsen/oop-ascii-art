package loaders.image.random

import asciiApp.models.grid.PixelGrid
import asciiApp.models.image.Image
import asciiApp.models.pixels.RGBPixel
import loaders.RandomLoader
import loaders.image.RGBImageLoader

import scala.collection.mutable
import scala.util.Random

class RGBImageRandomLoader(random: Random)
    extends RandomLoader[Image[RGBPixel]]
    with RGBImageLoader {
  override def load(): Image[RGBPixel] = {
    val width = random.between(1, 1000)
    val height = random.between(1, 1000)
    val pixels =
      mutable.ArraySeq
        .fill(height)(mutable.ArraySeq.fill(width)(randomPixel()).toSeq)
        .toSeq
    new Image(new PixelGrid(pixels))
  }

  private def randomPixel(): RGBPixel =
    new RGBPixel(
      random.between(0, 256),
      random.between(0, 256),
      random.between(0, 256))
}
