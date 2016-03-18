object Solution {

  def main(args: Array[String]) {
    val n = readInt()
    val input = readLine().split(" ").map(_.toInt)
    val result = input.sorted.mkString(" ")
    println(result)
  }
}
