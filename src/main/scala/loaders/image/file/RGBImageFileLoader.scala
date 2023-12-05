package loaders.image.file

import asciiApp.models.image.Image
import asciiApp.models.pixels.RGBPixel
import converters.image.rgb.BufferedImageToRGBImageConverter
import loaders.FileLoader
import loaders.external.file.BufferedImageFileLoader
import loaders.image.RGBImageLoader

import java.io.File
import java.nio.file.Paths

class RGBImageFileLoader(
  image: File,
  javaImageToRGBImageConverter: BufferedImageToRGBImageConverter)
    extends FileLoader[Image[RGBPixel]]
    with RGBImageLoader {
  require(image.isFile, "Unable to load file: " + image.getAbsolutePath)
  require(
    Seq("png", "gif", "jpg").contains(
      Paths.get(image.getAbsolutePath).getFileName.toString.split("\\.").last),
    "Wrong file extension: " + Paths
      .get(image.getAbsolutePath)
      .getFileName
      .toString
      .split("\\.")
      .last
  )
  require(image.canRead, "Unable to read file: " + image.getAbsolutePath)

  override def load(): Image[RGBPixel] =
    javaImageToRGBImageConverter.convert(
      new BufferedImageFileLoader(image).load()
    )
}
