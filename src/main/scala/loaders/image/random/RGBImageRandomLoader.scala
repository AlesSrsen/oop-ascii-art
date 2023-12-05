package loaders.image.random

import loaders.RandomLoader
import loaders.image.RGBImageLoader
import models.grid.PixelGrid
import models.image.Image
import models.pixels.RGBPixel

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
