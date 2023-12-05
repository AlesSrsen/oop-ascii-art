package loaders.image

import asciiApp.models.image.Image
import asciiApp.models.pixels.RGBPixel

trait RGBImageLoader extends ImageLoader[Image[RGBPixel]] {}
