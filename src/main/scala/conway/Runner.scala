package conway

object Runner extends App {

  val width  = 170
  val height = 50
  val generations = 5000
  val game = new Game(width,height)

  var current_generation = game.randomize
  GamePrinter(width, height, current_generation)

  for (gen <- 1 to generations) {
    current_generation = game.evolve(current_generation)
    print(27.toChar + "[2J") /* clear screen */
    GamePrinter(width, height, current_generation)
    println(s"Generation #$gen")
    Thread.sleep(100)
  }
}
