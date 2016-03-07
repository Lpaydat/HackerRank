object Solution {
  
  def getGcf(strList: List[String]): String = {
    def mkIntIntList(s: String): List[(Int,Int)] =
      s.split(" ").map(_.toInt).sliding(2,2).toList.map(arr => (arr(0), arr(1)))

    def gcf(lst: List[List[(Int,Int)]], filtered: List[(Int,Int)]): List[(Int,Int)] =
      if (lst.isEmpty) filtered
      else gcf(lst.tail, intersection(lst.head, filtered))
    def intersection(rawLst: List[(Int,Int)], filtered: List[(Int,Int)]): List[(Int,Int)] =
      for {
        f <- filtered
        r <- rawLst
        if f._1 == r._1
      } yield (f._1, if (f._2 <= r._2) f._2 else r._2)

    def tupleToList(gcf: List[(Int,Int)]): List[String] =
      if (gcf.isEmpty) Nil
      else gcf.head._1 +" "+ gcf.head._2 :: tupleToList(gcf.tail)

    val intIntList = for (str <- strList) yield mkIntIntList(str)
    val gcfList = gcf(intIntList.tail, intIntList.head)
    tupleToList(gcfList).mkString(" ")
  }

  def main(args: Array[String]) {
    val input = io.Source.stdin.getLines().drop(1).toList
    println(getGcf(input))
  }
}
