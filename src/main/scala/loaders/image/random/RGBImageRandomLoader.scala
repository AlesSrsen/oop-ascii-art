package loaders.image.random

import loaders.RandomLoader
import loaders.image.RGBImageLoader
import models.grid.PixelGrid
import models.image.RGBImage
import models.pixels.RGBPixel

import java.util.Random
import scala.collection.mutable

class RGBImageRandomLoader(random: Random)
    extends RandomLoader[RGBImage]
    with RGBImageLoader {
  override def load(): RGBImage = {
    val width = random.nextInt(1, 1000)
    val height = random.nextInt(1, 1000)
    val pixels =
      mutable.ArraySeq
        .fill(height)(mutable.ArraySeq.fill(width)(randomPixel()).toSeq)
        .toSeq
    new RGBImage(new PixelGrid(pixels))
  }

  private def randomPixel(): RGBPixel =
    new RGBPixel(
      random.nextInt(0, 256),
      random.nextInt(0, 256),
      random.nextInt(0, 256))
}
