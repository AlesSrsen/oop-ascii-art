package helpers

import java.io.File

trait TestWithFiles {
  val testFilesFolderPath: String = "src/test/resources/"
  val testImagesFolderPath: String = testFilesFolderPath + "images/"
  val defaultTempExtension: String = ".tmp"

  def getImageFromResources(testImageName: String): File = {
    val image = new File(testImagesFolderPath + testImageName)
    require(image.isFile, "Unable to load file: " + image.getAbsolutePath)
    require(image.canRead, "Unable to read file: " + image.getAbsolutePath)
    image
  }

  def getRandomExistingTempFile(ext: String = defaultTempExtension): File = {
    val file = getRandomNonExistingTempFile(ext)
    require(
      file.createNewFile(),
      "Unable to create random empty file: " + file.getAbsolutePath)
    require(file.canWrite, "Unable to write to file: " + file.getAbsolutePath)
    file
  }

  def getRandomNonExistingTempFile(ext: String = defaultTempExtension): File = {
    val file = new File(
      testFilesFolderPath + java.util.UUID.randomUUID().toString +
        ext)
    require(!file.exists(), "File already exists: " + file.getAbsolutePath)
    file
  }

  def deleteFile(file: File): Unit = {
    if (!file.exists()) return
    file.deleteOnExit()
  }

  def assertFileContent(file: File, expectedContent: String): Unit = {
    assertFileExists(file)
    require(file.canRead, "Unable to read file: " + file.getAbsolutePath)
    val source = scala.io.Source.fromFile(file)
    val content = try source.mkString
    finally source.close()
    assert(content == expectedContent)
  }

  def assertFileExists(file: File): Unit =
    assert(file.exists(), "File does not exist: " + file.getAbsolutePath)
}
