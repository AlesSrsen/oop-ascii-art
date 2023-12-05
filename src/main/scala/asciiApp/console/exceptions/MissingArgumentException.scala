package asciiApp.console.exceptions

class MissingArgumentException(
  private val message: String = "",
  private val cause: Throwable = None.orNull)
    extends ArgumentOptionException(message, cause)
