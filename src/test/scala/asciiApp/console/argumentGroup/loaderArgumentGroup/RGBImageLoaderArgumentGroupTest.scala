package asciiApp.console.argumentGroup.loaderArgumentGroup

import helpers.TestWithFiles
import loaders.image.file.PNGRGBImageFileLoader
import org.scalatest.FunSuite

class RGBImageLoaderArgumentGroupTest extends FunSuite with TestWithFiles {
  test("Check if unparsed arguments are kept") {
    val rgbImageLoaderArgumentGroup = new RGBImageLoaderArgumentGroup()
    val testFile = getRandomExistingTempFile(".png")
    val arguments = rgbImageLoaderArgumentGroup.parse(
      Seq("other", "-i", testFile.getAbsolutePath, "other")
    )
    assert(
      rgbImageLoaderArgumentGroup.getParsingResult.head
        .isInstanceOf[PNGRGBImageFileLoader])

    assert(arguments == Seq.fill(2)("other"))
    deleteFile(testFile)
  }
}
