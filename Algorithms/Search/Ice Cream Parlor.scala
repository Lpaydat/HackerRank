object Solution {
  
  def getFlavorsIndex(dollars: Int, costs: List[Int]): String = {
    def gfi(c: List[Int], i: Int = 1): String = c match {
      case Nil => ""
      case h :: t =>
        val wanted = dollars - h
        if (t.contains(wanted))
          (i +" "+ (t.indexOf(wanted) + i + 1)) + gfi(Nil, 0)
        else gfi(t, i + 1)
    }
    gfi(costs)
  }

  def main(args: Array[String]) {
    val t = readInt()
    val tc = for(i <- 1 to t) yield
      (readInt(), readInt(), readLine().split(" ").map(_.toInt).toList)
    for (x <- tc) println(getFlavorsIndex(x._1, x._3))
  }
}
