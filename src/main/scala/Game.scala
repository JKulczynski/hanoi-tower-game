import scala.io.StdIn.readInt

class Game {
 def Play(towers: List[List[Int]] = List(List(1,2,3), List[Int](), List[Int]())): Unit = {
   Display(towers)
   if(GameOver(towers)) {
     println("You win!")
     return
   }
   val from = GetMoveTower("Pick a from tower: 0,1,2")
   val to = GetMoveTower("Pick a to tower: 0,1,2")
   val moveResult = Move(from,to,towers)
   Play(moveResult)
 }
  def Move(from: Int, to: Int, towers: List[List[Int]]): List[List[Int]] = {
    if(!CanMove(from,to,towers)) {
      println("Can't move there")
      return towers
    }

    val disk = towers(from).head
    var i = 0
    towers.foldLeft(List[List[Int]]())((r,l) =>
    if (i == from) {
      i += 1
      r ::: List(l.tail)
    } else if (i == to) {
      i+=1
      r ::: List(List(disk) ::: l)
    } else {
      i+=1
      r ::: List(l)
    }
    )
  }

  def CanMove(from: Int, to: Int, towers: List[List[Int]]): Boolean = {
    towers(to).length == 0 || towers(from).head < towers(to).head
  }

  def GameOver(towers: List[List[Int]]): Boolean = {
    towers(0).length == 0 && towers(2).length == 3
  }

  def Display(towers: List[List[Int]]): Unit ={
    println(towers(0))
    println(towers(1))
    println(towers(2))
  }

  def GetMoveTower(message: String): Int = {
    println(message)
    readInt
  }
}

