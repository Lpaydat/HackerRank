object Solution {
  
  def isLeftEqualRight(list: List[Int]) = {
    def findSweetSpot(lst: List[Int], left: Int, right: Int): String = (lst, left, right) match {
      case (Nil, _, _) => "NO"
      case (h :: t, l, r) if l == r - h => "YES"
      case (h :: t, l, r) => findSweetSpot(t, l + h, r - h)
    }
    findSweetSpot(list, 0, list.sum)
  }

  def main(args: Array[String]) {
    val n = readInt()
    val input = for (i <- 1 to n) yield
      (readInt(), readLine().split(" ").map(_.toInt).toList)
    input.foreach(x => println(isLeftEqualRight(x._2)))
  }
}
