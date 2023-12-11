package loaders.image.file

import converters.image.rgb.BufferedImageToRGBImageConverter

import java.io.File

/**
 * Used to load an RGB image from a jpg file
 * @param image File to load
 * @param javaImageToRGBImageConverter Converter used to convert a Java BufferedImage to an Image[RGBPixel]
 */
class JpgRGBImageFileLoader(
  image: File,
  javaImageToRGBImageConverter: BufferedImageToRGBImageConverter =
    new BufferedImageToRGBImageConverter)
    extends RGBImageFileLoader(image, javaImageToRGBImageConverter) {
  require(
    Seq("jpg").contains(getFileExtension(image)),
    "Wrong file extension: " + getFileExtension(image)
  )
}
