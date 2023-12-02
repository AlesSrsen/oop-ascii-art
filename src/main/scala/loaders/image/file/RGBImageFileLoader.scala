package loaders.image.file

import converters.image.rgb.BufferedImageToRGBImageConverter
import loaders.FileLoader
import loaders.external.file.BufferedImageFileLoader
import loaders.image.ImageLoader
import models.image.RGBImage

class RGBImageFileLoader(
  imageFilename: String,
  javaImageToRGBImageConverter: BufferedImageToRGBImageConverter)
    extends FileLoader[RGBImage]
    with ImageLoader[RGBImage] {
  override def load(): RGBImage =
    javaImageToRGBImageConverter.convert(
      new BufferedImageFileLoader(imageFilename).load()
    )
}
