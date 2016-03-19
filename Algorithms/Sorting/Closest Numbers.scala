object Solution {

  def closestNumbers(sortedList: List[Int]) = {
    def mapDifferent(lst: List[Int]): List[(Int, Int, Int)] = lst match {
      case h :: Nil => Nil
      case h :: t =>
        val hx = t.head
        ((h - hx).abs, h, hx) :: mapDifferent(t)
      case _ => Nil
    }
    val computed = mapDifferent(sortedList).sorted
    val smallestGap = computed.head._1
    val winnerGroup = computed.filter(_._1 == smallestGap)
    winnerGroup.map(x => x._2 +" "+ x._3).mkString(" ")
  }
  
  def main(args: Array[String]) {
    val n = readInt()
    val input = readLine().split(" ").map(_.toInt).toList.sorted
    println(closestNumbers(input))
  }
}
