object Solution {
  
  def insertionSort(l: Array[Int]) = {
    var shiftCount = 0
    for (i <- 1 until l.length) {
      var j = i - 1
      val key = l(i)
      while (j >= 0 && l(j) > key) {
        l(j + 1) = l(j)
        j = j - 1
        shiftCount = shiftCount + 1
      }
      l(j + 1) = key
    }
    shiftCount
  }

  def main(args: Array[String]) {
    val x = readInt()
    val input = readLine().split(" ").map(_.toInt)
    println(insertionSort(input))
  }
}
