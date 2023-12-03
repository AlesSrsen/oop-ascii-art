package filters.image

import models.image.Image

class DownscaleImageFilter extends ImageFilter[Image[_]] {
  override def applyFilter(item: Image[_]): Image[_] = ???
}
