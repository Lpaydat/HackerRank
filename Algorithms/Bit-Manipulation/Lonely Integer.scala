object Solution {

  def main(args: Array[String]) {
    val n = readInt()
    val input = readLine().split(" ").map(_.toInt)
    val count = input.groupBy(identity).mapValues(_.size).toList
    println(count.filter(_._2 == 1).head._1)
  }
}
