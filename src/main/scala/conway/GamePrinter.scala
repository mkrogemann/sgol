package conway

object GamePrinter {
  def apply(width: Int, height: Int, state: Map[(Int,Int), Boolean]): Unit = {
    for (y <- 1 to height) {
      for (x <- 1 to width) {
          state.get((x,y)) match {
          case Some(true) => print('o')
          case _ => print(' ')
        }
      }
      println()
    }
  }
}
