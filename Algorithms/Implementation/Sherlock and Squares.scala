object Solution {
  
  def getSqrtList(a: Int, b: Int): Int = {
    val x = Math.sqrt(a).toInt
    val y = Math.sqrt(b).toInt
    (for (i <- x to y) yield i * i).toList.count(x => x >= a && x <= b)
  }

  def main(args: Array[String]) {
    val n = readInt()
    val input = for (i <- 1 to n) yield readLine().split(" ").map(_.toInt)
    input.foreach(x => println(getSqrtList(x(0), x(1))))
  }
}
