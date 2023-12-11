package loaders.image.file

import asciiApp.models.image.Image
import asciiApp.models.pixels.RGBPixel
import converters.image.rgb.BufferedImageToRGBImageConverter
import loaders.FileLoader
import loaders.external.file.BufferedImageFileLoader
import loaders.image.RGBImageLoader

import java.io.File
import java.nio.file.Paths

/**
 * Used to load an RGB image from a file
 * Currently supports png, gif, and jpg
 * @param image File to load
 * @param javaImageToRGBImageConverter Converter used to convert a Java BufferedImage to an Image[RGBPixel]
 */
class RGBImageFileLoader(
  image: File,
  javaImageToRGBImageConverter: BufferedImageToRGBImageConverter =
    new BufferedImageToRGBImageConverter)
    extends FileLoader[Image[RGBPixel]]
    with RGBImageLoader {
  require(image.isFile, "Unable to load file: " + image.getAbsolutePath)
  require(
    Seq("png", "gif", "jpg").contains(getFileExtension(image)),
    "Wrong file extension: " + getFileExtension(image)
  )
  require(image.canRead, "Unable to read file: " + image.getAbsolutePath)

  /**
   * Loads an RGB image from a file
   * @return RGB image loaded from file
   */
  override def load(): Image[RGBPixel] =
    javaImageToRGBImageConverter.convert(
      new BufferedImageFileLoader(image).load()
    )

  protected def getFileExtension(file: File): String =
    Paths
      .get(file.getAbsolutePath)
      .getFileName
      .toString
      .split("\\.")
      .last
}
