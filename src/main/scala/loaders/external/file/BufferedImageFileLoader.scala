package loaders.external.file

import loaders.FileLoader

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class BufferedImageFileLoader(imageFilename: String)
    extends FileLoader[BufferedImage] {
  override def load(): BufferedImage =
    ImageIO.read(new File(imageFilename))
}
