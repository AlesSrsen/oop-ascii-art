package loaders.image.file

import converters.image.rgb.BufferedImageToRGBImageConverter
import loaders.FileLoader
import loaders.external.file.BufferedImageFileLoader
import loaders.image.RGBImageLoader
import models.image.RGBImage

import java.io.File

class RGBImageFileLoader(
  image: File,
  javaImageToRGBImageConverter: BufferedImageToRGBImageConverter)
    extends FileLoader[RGBImage]
    with RGBImageLoader {
  override def load(): RGBImage =
    javaImageToRGBImageConverter.convert(
      new BufferedImageFileLoader(image).load()
    )
}
