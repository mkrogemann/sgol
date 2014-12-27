package conway

object MicroBench extends App {
    val width = 16
    val height = 16
    val generations = 30000
    val game = new Game(width, height)

    var current_generation = randomize(width, height)

    var then: Long = System.currentTimeMillis

    for (gen <- 1 to generations) {
        current_generation = game.evolve(current_generation)
        if (gen % 2000 == 0) {
            println(gen + " generations done, last 2000 took " + (System.currentTimeMillis - then))
            then = System.currentTimeMillis
        }
    }
}
