package exporters.image

import asciiApp.models.image.Image
import exporters.Exporter

trait ImageExporter[T <: Image[_]] extends Exporter[T] {}
