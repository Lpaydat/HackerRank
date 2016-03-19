object Solution {

  def main(args: Array[String]) {
    val n = readInt()
    val input = readLine().split(" ").map(_.toInt)
    val counted = input.groupBy(identity).mapValues(_.length)
    val result = for (i <- 0 to 99) yield
      if (counted.exists(_._1 == i)) counted(i) else 0
    println(result.mkString(" "))
  }
}
