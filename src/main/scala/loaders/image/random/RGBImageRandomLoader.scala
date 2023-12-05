package loaders.image.random

import loaders.RandomLoader
import loaders.image.RGBImageLoader
import models.grid.PixelGrid
import models.image.Image
import models.pixels.RGBPixel

import java.util.Random
import scala.collection.mutable

class RGBImageRandomLoader(random: Random)
    extends RandomLoader[Image[RGBPixel]]
    with RGBImageLoader {
  override def load(): Image[RGBPixel] = {
    val width = random.nextInt(1, 1000)
    val height = random.nextInt(1, 1000)
    val pixels =
      mutable.ArraySeq
        .fill(height)(mutable.ArraySeq.fill(width)(randomPixel()).toSeq)
        .toSeq
    new Image(new PixelGrid(pixels))
  }

  private def randomPixel(): RGBPixel =
    new RGBPixel(
      random.nextInt(0, 256),
      random.nextInt(0, 256),
      random.nextInt(0, 256))
}
