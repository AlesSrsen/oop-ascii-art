package asciiApp.ui.controllers

import asciiApp.ui.views.ConsoleView
import helpers.TestWithFiles
import org.scalatest.FunSuite

import java.io.ByteArrayOutputStream

class ConsoleControllerTest extends FunSuite with TestWithFiles {
  test("Example run on test file") {
    val result = getRandomNonExistingTempFile(".txt");

    val args: Seq[String] =
      Seq(
        "--image",
        getImageFromResources("testing_grid_image.png").getAbsolutePath,
        "--output-file",
        result.getAbsolutePath,
        "--table-bourke-short",
        "--flip",
        "y"
      )
    val controller =
      new ConsoleController(args, new ConsoleView(new ByteArrayOutputStream))

    controller.run()

    assertFileContent(result, " %=*@" + System.lineSeparator() + " +:+.")
    deleteFile(result)
  }

  test("Missing required loader argument") {
    val result = getRandomNonExistingTempFile()

    val args: Seq[String] =
      Seq(
        "--output-file",
        result.getAbsolutePath,
        "--table-bourke-short",
        "--flip",
        "y"
      )

    val outputStream = new ByteArrayOutputStream()
    val controller =
      new ConsoleController(args, new ConsoleView(outputStream))

    controller.run();

    assert(
      outputStream.toString ==
        "[ERROR]" + System.lineSeparator() +
          "Missing argument: No loader specified" + System.lineSeparator()
    )

    deleteFile(result)
  }

  test("Invalid argument") {
    val result = getRandomNonExistingTempFile()

    val args: Seq[String] =
      Seq(
        "--image",
        getImageFromResources("testing_grid_image.png").getAbsolutePath,
        "--output-file",
        result.getAbsolutePath,
        "--table-bourke-short",
        "--flip",
        "y",
        "--invalid-argument"
      )

    val outputStream = new ByteArrayOutputStream()
    val controller =
      new ConsoleController(args, new ConsoleView(outputStream))

    controller.run();

    assert(
      outputStream.toString ==
        "[ERROR]" + System.lineSeparator() +
          "Invalid argument: --invalid-argument" + System.lineSeparator()
    )

    deleteFile(result)
  }
}
