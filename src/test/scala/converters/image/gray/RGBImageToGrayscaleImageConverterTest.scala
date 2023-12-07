package converters.image.gray

import asciiApp.models.pixels.{GrayscalePixel, RGBPixel}
import helpers.TestWithImages
import org.scalatest.FunSuite

/**
 * Images are converted based on the formula: gray = 0.3 * red + 0.59 * green + 0.11 * blue
 * @see [[https://www.tutorialspoint.com/dip/grayscale_to_rgb_conversion.htm]]
 */
class RGBImageToGrayscaleImageConverterTest
    extends FunSuite
    with TestWithImages {

  def calculateGrayValue(red: Int, green: Int, blue: Int): Int =
    ((0.3 * red) + (0.59 * green) + (0.11 * blue)).toInt

  test("Convert Image[RGBPixel] to Image[GrayscalePixel]") {
    val image = createImage(
      Seq(
        Seq(
          new RGBPixel(0, 0, 0),
          new RGBPixel(255, 0, 0),
          new RGBPixel(0, 255, 0),
          new RGBPixel(0, 0, 255),
          new RGBPixel(255, 255, 255)
        ),
        Seq(
          new RGBPixel(255, 255, 0),
          new RGBPixel(255, 0, 255),
          new RGBPixel(0, 255, 255),
          new RGBPixel(100, 100, 100),
          new RGBPixel(255, 255, 255)
        )
      )
    )

    val convertedImage = new RGBImageToGrayscaleImageConverter().convert(image)

    compareImagePixels(
      convertedImage,
      createImage(
        Seq(
          Seq(
            new GrayscalePixel(calculateGrayValue(0, 0, 0)),
            new GrayscalePixel(calculateGrayValue(255, 0, 0)),
            new GrayscalePixel(calculateGrayValue(0, 255, 0)),
            new GrayscalePixel(calculateGrayValue(0, 0, 255)),
            new GrayscalePixel(calculateGrayValue(255, 255, 255))
          ),
          Seq(
            new GrayscalePixel(calculateGrayValue(255, 255, 0)),
            new GrayscalePixel(calculateGrayValue(255, 0, 255)),
            new GrayscalePixel(calculateGrayValue(0, 255, 255)),
            new GrayscalePixel(calculateGrayValue(100, 100, 100)),
            new GrayscalePixel(calculateGrayValue(255, 255, 255))
          )
        )
      )
    )
  }

  test(
    "Convert 1x1px Image[RGBPixel] with black pixel to Image[GrayscalePixel]") {
    val image = createImage(Seq(Seq(new RGBPixel(0, 0, 0))))
    val convertedImage = new RGBImageToGrayscaleImageConverter().convert(image)
    compareImagePixels(
      convertedImage,
      createImage(Seq(Seq(new GrayscalePixel(calculateGrayValue(0, 0, 0))))))
  }

  test(
    "Convert 1x1px Image[RGBPixel] with white pixel to Image[GrayscalePixel]") {
    val image = createImage(Seq(Seq(new RGBPixel(255, 255, 255))))
    val convertedImage = new RGBImageToGrayscaleImageConverter().convert(image)
    compareImagePixels(
      convertedImage,
      createImage(
        Seq(Seq(new GrayscalePixel(calculateGrayValue(255, 255, 255))))))
  }

  test("Convert 1x1px Image[RGBPixel] with red pixel to Image[GrayscalePixel]") {
    val image = createImage(Seq(Seq(new RGBPixel(255, 0, 0))))
    val convertedImage = new RGBImageToGrayscaleImageConverter().convert(image)
    compareImagePixels(
      convertedImage,
      createImage(Seq(Seq(new GrayscalePixel(calculateGrayValue(255, 0, 0))))))
  }

  test(
    "Convert 1x1px Image[RGBPixel] with green pixel to Image[GrayscalePixel]") {
    val image = createImage(Seq(Seq(new RGBPixel(0, 255, 0))))
    val convertedImage = new RGBImageToGrayscaleImageConverter().convert(image)
    compareImagePixels(
      convertedImage,
      createImage(Seq(Seq(new GrayscalePixel(calculateGrayValue(0, 255, 0))))))
  }

  test("Convert 1x1px Image[RGBPixel] with blue pixel to Image[GrayscalePixel]") {
    val image = createImage(Seq(Seq(new RGBPixel(0, 0, 255))))
    val convertedImage = new RGBImageToGrayscaleImageConverter().convert(image)
    compareImagePixels(
      convertedImage,
      createImage(Seq(Seq(new GrayscalePixel(calculateGrayValue(0, 0, 255))))))
  }
}
