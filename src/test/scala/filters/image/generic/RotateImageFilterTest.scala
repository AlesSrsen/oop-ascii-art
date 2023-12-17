package filters.image.generic

import asciiApp.models.image.Image
import helpers.TestWithImages
import helpers.stubs.StubPixel
import org.scalatest.FunSuite

class RotateImageFilterTest extends FunSuite with TestWithImages {
  val imageToRotate: Image[StubPixel] = createImage(
    Vector(
      Vector(new StubPixel(0), new StubPixel(100)),
      Vector(new StubPixel(200), new StubPixel(250)),
      Vector(new StubPixel(30), new StubPixel(50))
    )
  )

  val rotatedBy90Degrees: Image[StubPixel] = createImage(
    Vector(
      Vector(new StubPixel(30), new StubPixel(200), new StubPixel(0)),
      Vector(new StubPixel(50), new StubPixel(250), new StubPixel(100))
    )
  )

  val rotatedBy180Degrees: Image[StubPixel] = createImage(
    Vector(
      Vector(new StubPixel(50), new StubPixel(30)),
      Vector(new StubPixel(250), new StubPixel(200)),
      Vector(new StubPixel(100), new StubPixel(0))
    )
  )

  val rotatedBy270Degrees: Image[StubPixel] = createImage(
    Vector(
      Vector(new StubPixel(100), new StubPixel(250), new StubPixel(50)),
      Vector(new StubPixel(0), new StubPixel(200), new StubPixel(30))
    )
  )

  test("Check rotate by 90 degrees") {
    val rotatedImage = new RotateImageFilter(90).applyFilter(imageToRotate)

    compareImagePixels(
      rotatedImage,
      rotatedBy90Degrees
    )
  }

  test("Check rotations from -3600 to 3600 degrees") {
    for (i <- -3600 to 3600 by 90) {
      val rotatedImage = new RotateImageFilter(i).applyFilter(imageToRotate)

      val rotation = i % 360
      val toMatch = if (rotation < 0) 360 + rotation else rotation

      val expectedImage = toMatch match {
        case 90  => rotatedBy90Degrees
        case 180 => rotatedBy180Degrees
        case 270 => rotatedBy270Degrees
        case _   => imageToRotate
      }

      compareImagePixels(
        rotatedImage,
        expectedImage
      )
    }
  }

  test("Check invalid rotation") {
    assertThrows[IllegalArgumentException] {
      new RotateImageFilter(91)
    }
  }
}
