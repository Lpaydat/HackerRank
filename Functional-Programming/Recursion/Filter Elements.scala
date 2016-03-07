object Solution {
  
  def filterByNumber(listInt: List[Int], n: Int): String = {
    def findMember(numbers: List[Int], winner: List[Int] = Nil, loser: List[Int] = Nil): List[Int] = {
      numbers match {
        case Nil => winner
        case h :: t =>
          if (winner.contains(h) || loser.contains(h))
            findMember(t, winner, loser)
          else {
            val count = numbers.count(_ == h)
            if (count < n) findMember(t, winner, h :: loser)
            else findMember(t, h :: winner, loser)
          }
      }
    }
    val result = findMember(listInt)
    if (result.isEmpty) "-1" else result.reverse.mkString(" ")
  }

  def main(args: Array[String]) {
    val input = io.Source.stdin.getLines().drop(1).toList.map(_.split(" ").map(_.toInt).toList)    
    for (i <- input.indices if i % 2 == 0)
      println(filterByNumber(input(i + 1),input(i)(1)))
  }
}
