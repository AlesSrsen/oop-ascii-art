package exporters.image

import exporters.Exporter
import models.image.Image

trait ImageExporter[T <: Image[_]] extends Exporter[T] {}
