package loaders.external.file

import loaders.FileLoader

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * Used to load a BufferedImage from a file
 * Currently supports png, gif, and jpg
 * @param image File to load
 */
class BufferedImageFileLoader(image: File) extends FileLoader[BufferedImage] {
  require(image.isFile, "Unable to load file: " + image.getAbsolutePath)
  require(image.canRead, "Unable to read file: " + image.getAbsolutePath)

  override def load(): BufferedImage =
    ImageIO.read(image)
}
