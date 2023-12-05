package console.exceptions

class InvalidArgumentOptionException(
  private val message: String = "",
  private val cause: Throwable = None.orNull)
    extends ArgumentOptionException(message, cause)
