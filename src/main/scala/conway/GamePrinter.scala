package conway

import scala.collection.parallel.immutable.ParMap

object GamePrinter {
  def apply(width: Int, height: Int, state: ParMap[(Int, Int), Boolean]): Unit = {
    for (y <- 1 to height) {
      for (x <- 1 to width) {
        state.get((x, y)) match {
          case Some(true) => print('o')
          case _ => print(' ')
        }
      }
      println()
    }
  }
}
