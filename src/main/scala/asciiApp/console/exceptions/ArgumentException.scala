package asciiApp.console.exceptions

class ArgumentException(
  private val message: String = "",
  private val cause: Throwable = None.orNull)
    extends Exception(message, cause)
