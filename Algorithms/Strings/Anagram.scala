object Solution {
  
  def makeItAnagram(s: String): Int = {
    def grouping(str: String) = str.groupBy(identity).mapValues(_.length).toList
    def countReplace(list: List[(Char, Int)]): List[Int] = list match {
      case Nil => Nil
      case h :: hx :: t if h._1 == hx._1 => (h._2 - hx._2).abs :: countReplace(t)
      case h :: t => h._2 :: countReplace(t)
    }
    val len = s.length
    if (len % 2 != 0) -1
    else {
      val halfLen = len / 2
      val merged = (grouping(s.take(halfLen)) ::: grouping(s.drop(halfLen))).sorted
      countReplace(merged).sum / 2
    }
  }

  def main(args: Array[String]) {
    val n = readInt()
    val strList = for (i <- 1 to n) yield readLine()
    strList.foreach(s => println(makeItAnagram(s)))
  }
}
