package filters.image.gray.flip

import filters.image.ImageFilter
import filters.pixelGrid.flip.XFlipPixelGridFilter
import models.image.GrayscaleImage

class XFlipGrayscaleImageFilter extends ImageFilter[GrayscaleImage] {
  override def applyFilter(item: GrayscaleImage): GrayscaleImage =
    new GrayscaleImage(new XFlipPixelGridFilter().applyFilter(item.pixels))
}
