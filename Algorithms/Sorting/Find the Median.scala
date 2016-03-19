object Solution {

  def main(args: Array[String]) {
    val n = readInt()
    val input = readLine().split(" ").map(_.toInt).sorted
    val medianPos = input.length / 2
    println(input(medianPos))
  }
}
