package conway

import scala.util.Random

class Game(val width: Int, val height: Int) {

    def randomize = {
        var random_state = scala.collection.mutable.Map[(Int, Int), Boolean]()
        for (x <- 1 to this.width) {
            for (y <- 1 to this.height) {
                random_state += (x, y) -> Random.nextBoolean()
            }
        }
        random_state.toMap
    }

    def evolve(current_gen: Map[(Int, Int), Boolean]): Map[(Int, Int), Boolean] = {
        current_gen map { case (k, v) => k -> Rules(neighbors(current_gen, k._1, k._2), alive = v)}
    }

    def neighbors(current_gen: Map[(Int, Int), Boolean], x: Int, y: Int): Int = {
        def alive(x: Int, y: Int): Boolean = current_gen.get(wrapOrGet(x, y)) exists (v => v)
        List(
            (x - 1, y - 1), (x, y - 1), (x + 1, y - 1),
            (x - 1, y), (x + 1, y),
            (x - 1, y + 1), (x, y + 1), (x + 1, y + 1)).count(t => alive(t._1, t._2))
    }

    private def wrapOrGet(x: Int, y: Int): (Int, Int) = Tuple2(
        if (x < 1) this.width else if (x > this.width) 1 else x,
        if (y < 1) this.height else if (y > this.height) 1 else y
    )
}
