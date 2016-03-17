object Solution {

  def main(args: Array[String]) {
    val v = readInt()
    val n = readInt()
    val ar = readLine().split(" ").map(_.toInt)
    println(ar.indexOf(v))
  }
}
