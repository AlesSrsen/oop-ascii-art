package loaders.image

import models.image.Image
import models.pixels.RGBPixel

trait RGBImageLoader extends ImageLoader[Image[RGBPixel]] {}
