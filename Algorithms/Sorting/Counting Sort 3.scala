object Solution {
  
  def accumulate(counted: Map[Int, Int]) = {
    def acc(n: Int = 0, i: Int = 0): List[Int] = n match {
      case 100 => Nil
      case _ if counted.exists(_._1 == n) =>
        val added = i + counted(n)
        added :: acc(n + 1, added)
      case _ => i :: acc(n + 1, i)
    }
    acc().mkString(" ")
  }

  def main(args: Array[String]) {
    val n = readInt()
    val input = for (i <- 1 to n) yield readLine().split(" ")(0).toInt
    val counted = input.groupBy(identity).mapValues(_.size)
    println(accumulate(counted))
  }
}
