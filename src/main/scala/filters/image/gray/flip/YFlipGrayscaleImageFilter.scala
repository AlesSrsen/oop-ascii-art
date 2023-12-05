package filters.image.gray.flip

import filters.image.ImageFilter
import filters.pixelGrid.flip.YFlipPixelGridFilter
import models.image.GrayscaleImage

class YFlipGrayscaleImageFilter extends ImageFilter[GrayscaleImage] {
  override def applyFilter(item: GrayscaleImage): GrayscaleImage =
    new GrayscaleImage(new YFlipPixelGridFilter().applyFilter(item.pixels))
}
