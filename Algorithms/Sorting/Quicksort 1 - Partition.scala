object Solution {

  def main(args: Array[String]) {
    val n = readInt()
    val input = readLine().split(" ").map(_.toInt)
    val (a, b) = input.partition(_ < input(0))
    println((a ++ b).mkString(" "))
  }
}
