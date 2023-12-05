package console.exceptions

class InvalidArgumentException(
  private val message: String = "",
  private val cause: Throwable = None.orNull)
    extends ArgumentException(message, cause)
