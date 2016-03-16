object Solution {
  
  def isFunny(str: String) = {
    def getDifferent(s: String) = {
      val ascii = s.toList.map(_.toInt)
      for (i <- ascii.indices if i > 0) yield (ascii(i) - ascii(i  - 1)).abs
    }
    val funny = getDifferent(str) == getDifferent(str.reverse)
    if (funny) "Funny" else "Not Funny"
  }

  def main(args: Array[String]) {
    val n = readInt()
    val s = (for (i <- 1 to n) yield readLine()).toList
    s.foreach(x => println(isFunny(x)))
  }
}
