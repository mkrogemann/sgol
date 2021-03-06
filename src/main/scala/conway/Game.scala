package conway

import scala.collection.parallel.immutable.ParMap

case class Game(width: Int, height: Int) {

    def evolve(current_gen: ParMap[(Int, Int), Boolean]): ParMap[(Int, Int), Boolean] = {
        current_gen map { case (k, v) => k -> Rules(neighbors(current_gen, k._1, k._2), alive = v)}
    }

    def neighbors(current_gen: ParMap[(Int, Int), Boolean], x: Int, y: Int): Int = {
        def alive(x: Int, y: Int): Boolean = current_gen.get(wrapOrGet(x, y)) exists (v => v)
        List(
            (x - 1, y - 1), (x, y - 1), (x + 1, y - 1),
            (x - 1, y), (x + 1, y),
            (x - 1, y + 1), (x, y + 1), (x + 1, y + 1)).count(t => alive(t._1, t._2))
    }

    private def wrapOrGet(x: Int, y: Int): (Int, Int) = (
        if (x < 1) this.width else if (x > this.width) 1 else x,
        if (y < 1) this.height else if (y > this.height) 1 else y
    )
}
