
object Hanoi extends App {

  println("Welcome to Tower of Hanoi Game")
  println(" ")
  println("Object of the game is to move all the disks over to Tower 3 ." +
    "\nBut you cannot place a larger disk onto a smaller disk.")
  println(" ")

  val game = new Game
  game.Play()

}
