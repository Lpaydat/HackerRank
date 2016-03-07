object Solution {
  
  def getGcf(strList: List[String]): String = {
    def mkIntIntList(s: String): List[(Int,Int)] =
      s.split(" ").map(_.toInt).sliding(2,2).toList.map(arr => (arr(0), arr(1)))

    def gcf(lst: List[List[(Int,Int)]], gcfLst: List[(Int,Int)]): List[(Int,Int)] =
      if (lst.isEmpty) gcfLst
      else gcf(lst.tail, extract(lst.head, gcfLst))
    def extract(rawLst: List[(Int,Int)], extracted: List[(Int,Int)]): List[(Int,Int)] =
      for {
        ex <- extracted
        rl <- rawLst
        if ex._1 == rl._1
      } yield (ex._1, if (ex._2 <= rl._2) ex._2 else rl._2)

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
