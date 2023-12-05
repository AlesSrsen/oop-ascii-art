package helpers

import java.io.File

trait TestWithFiles {
  val testFilesFolderPath: String = "src/test/resources/"
  val testImagesFolderPath: String = testFilesFolderPath + "images/"

  def getImage(testImageName: String): File = {
    val image = new File(testImagesFolderPath + testImageName)
    require(image.isFile, "Unable to load file: " + image.getAbsolutePath)
    require(image.canRead, "Unable to read file: " + image.getAbsolutePath)
    image
  }

  def getRandomNonExistingFile: File = {
    val file = new File(
      testImagesFolderPath + java.util.UUID.randomUUID().toString)
    require(!file.exists(), "File already exists: " + file.getAbsolutePath)
    file
  }
}
