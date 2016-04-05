object Solution {

  def main(args: Array[String]) {
    val n = readInt()
    val half = n / 2
    val input = for (i <- 1 to n) yield {
      val x = readLine().split(" ")
      if (i <= half) (x.head.toInt, "-")
      else (x.head.toInt, x.last)
    }
    val result = input.sortBy(_._1).map(_._2)
    println(result.mkString(" "))
  }
}
