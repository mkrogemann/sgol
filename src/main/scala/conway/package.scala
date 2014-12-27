import scala.collection.parallel.immutable.ParMap
import scala.util.Random

package object conway {

    protected[conway] def randomize(width: Int, height: Int): ParMap[(Int, Int), Boolean] = {
        var random_state = scala.collection.mutable.Map[(Int, Int), Boolean]()
        for (x <- 1 to width) {
            for (y <- 1 to height) {
                random_state += (x, y) -> Random.nextBoolean()
            }
        }
        random_state.toMap.par
    }

}
