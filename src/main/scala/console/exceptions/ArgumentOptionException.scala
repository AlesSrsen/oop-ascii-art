package console.exceptions

class ArgumentOptionException(
  private val message: String = "",
  private val cause: Throwable = None.orNull)
    extends ArgumentException(message, cause)
