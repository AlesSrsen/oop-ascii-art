package converters.image.rgb

import asciiApp.models.pixels.RGBPixel
import helpers.{TestWithFiles, TestWithImages}
import org.scalatest.FunSuite

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

class BufferedImageToRGBImageConverterTest
    extends FunSuite
    with TestWithImages
    with TestWithFiles {
  test("Convert BufferedImage to Image[RGBPixel]") {
    val testingImage = getImageFromResources("testing_grid_image.png")
    val bufferedImage = ImageIO.read(testingImage)
    val image = new BufferedImageToRGBImageConverter().convert(bufferedImage)

    compareImagePixels(
      image,
      createImage(
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
    )
  }

  test("Convert 1x1px BufferedImage with black pixel to Image[RGBPixel]") {
    val bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)
    val image = new BufferedImageToRGBImageConverter().convert(bufferedImage)
    compareImagePixels(image, createImage(Seq(Seq(new RGBPixel(0, 0, 0)))))
  }

  test("Convert 1x1px BufferedImage with white pixel to Image[RGBPixel]") {
    val bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)
    bufferedImage.setRGB(0, 0, 0xFFFFFF)
    val image = new BufferedImageToRGBImageConverter().convert(bufferedImage)
    compareImagePixels(
      image,
      createImage(Seq(Seq(new RGBPixel(255, 255, 255)))))
  }

  test("Convert 1x1px BufferedImage with red pixel to Image[RGBPixel]") {
    val bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)
    bufferedImage.setRGB(0, 0, 0xFF0000)
    val image = new BufferedImageToRGBImageConverter().convert(bufferedImage)
    compareImagePixels(image, createImage(Seq(Seq(new RGBPixel(255, 0, 0)))))
  }

  test("Convert 1x1px BufferedImage with green pixel to Image[RGBPixel]") {
    val bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)
    bufferedImage.setRGB(0, 0, 0x00FF00)
    val image = new BufferedImageToRGBImageConverter().convert(bufferedImage)
    compareImagePixels(image, createImage(Seq(Seq(new RGBPixel(0, 255, 0)))))
  }

  test("Convert 1x1px BufferedImage with blue pixel to Image[RGBPixel]") {
    val bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)
    bufferedImage.setRGB(0, 0, 0x0000FF)
    val image = new BufferedImageToRGBImageConverter().convert(bufferedImage)
    compareImagePixels(image, createImage(Seq(Seq(new RGBPixel(0, 0, 255)))))
  }
}
