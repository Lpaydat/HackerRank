object Solution {

  def main(args: Array[String]) {
    val n = readInt()
    val arr = readLine().split(" ").map(_.toInt)
    for (i <- 1 until arr.length) {
      var j = i - 1
      val key = arr(i)
      while (j >= 0 && arr(j) > key) {
        arr(j + 1) = arr(j)
        j = j - 1
        println(arr.mkString(" "))
      }
      arr(j + 1) = key
    }
    println(arr.mkString(" "))
  }
}
