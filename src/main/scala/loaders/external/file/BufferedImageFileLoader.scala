package loaders.external.file

import loaders.FileLoader

import java.awt.image.BufferedImage
import java.io.File
import java.nio.file.Paths
import javax.imageio.ImageIO

class BufferedImageFileLoader(image: File) extends FileLoader[BufferedImage] {
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

  override def load(): BufferedImage =
    ImageIO.read(image)
}
