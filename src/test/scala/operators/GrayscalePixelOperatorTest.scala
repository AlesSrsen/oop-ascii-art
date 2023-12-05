package operators

import asciiApp.models.pixels.GrayscalePixel
import org.scalatest.FunSuite
import org.scalatest.Matchers._

class GrayscalePixelOperatorTest extends FunSuite {

  test("Min") {
    val operator = new GrayscalePixelOperator()
    val min = operator.min()
    assert(min === GrayscalePixel.min())
  }

  test("Max") {
    val operator = new GrayscalePixelOperator()
    val max = operator.max()
    assert(max === GrayscalePixel.max())
  }

  test("Average GrayscalePixel") {
    val operator = new GrayscalePixelOperator()
    val a = new GrayscalePixel(10)
    val b = new GrayscalePixel(20)
    val average = operator.average(a, b)
    average.gray should be(15)
  }

  test("Add two GrayscalePixels") {
    val operator = new GrayscalePixelOperator()
    val a = new GrayscalePixel(10)
    val b = new GrayscalePixel(20)
    val add = operator.add(a, b)
    add.gray should be(30)
  }

  test("Subtract larger GrayscalePixel from smaller GrayscalePixel") {
    val operator = new GrayscalePixelOperator()
    val a = new GrayscalePixel(10)
    val b = new GrayscalePixel(20)
    val subtract = operator.subtract(a, b)
    subtract.gray should be(0)
  }

  test("Subtract smaller GrayscalePixel from larger GrayscalePixel") {
    val operator = new GrayscalePixelOperator()
    val a = new GrayscalePixel(20)
    val b = new GrayscalePixel(10)
    val subtract = operator.subtract(a, b)
    subtract.gray should be(10)
  }

  test("Invert GrayscalePixel") {
    val operator = new GrayscalePixelOperator()
    val a = new GrayscalePixel(10)
    val inverse = operator.inverse(a)
    inverse.gray should be(245)
  }

  test("Add positive scalar to GrayscalePixel") {
    val operator = new GrayscalePixelOperator()
    val a = new GrayscalePixel(10)
    val addScalar = operator.addScalar(a, 20)
    addScalar.gray should be(30)
  }

  test("Add larger negative scalar to GrayscalePixel") {
    val operator = new GrayscalePixelOperator()
    val a = new GrayscalePixel(10)
    val addScalar = operator.addScalar(a, -20)
    addScalar.gray should be(0)
  }

  test("Add smaller negative scalar to GrayscalePixel") {
    val operator = new GrayscalePixelOperator()
    val a = new GrayscalePixel(10)
    val addScalar = operator.addScalar(a, -5)
    addScalar.gray should be(5)
  }
}
