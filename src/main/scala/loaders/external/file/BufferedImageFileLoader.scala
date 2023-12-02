package loaders.external.file

import loaders.FileLoader

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class BufferedImageFileLoader(image: File) extends FileLoader[BufferedImage] {
  override def load(): BufferedImage =
    ImageIO.read(image)
}
