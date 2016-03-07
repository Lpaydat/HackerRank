object Solution {
  
  def getMissingNumbers(rowA: List[Int], rowB: List[Int]): String = {
    val groupA = rowA.groupBy(identity).mapValues(_.size).toList
    val groupB = rowB.groupBy(identity).mapValues(_.size).toList
    val onlyB = rowB.filterNot(rowA.toSet).distinct
    val bGreater = for {
      b <- groupB
      a <- groupA
      if b._1 == a._1 && b._2 > a._2
    } yield b._1

    (onlyB ::: bGreater).sorted.mkString(" ")
  }

  def main(args: Array[String]) {
    val input = for (i <- 1 to 4) yield readLine().split(" ").map(_.toInt).toList
    println(getMissingNumbers(input(1), input(3)))
  }
}
