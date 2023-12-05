package asciiApp.ui.views

trait View {
  def error(message: String): Unit
  def info(message: String): Unit
  def success(message: String): Unit
}
