object Solution {
  
  def insertionSort(arr: Array[Int]) = {
    def printProcess(ar: Array[Int], n: Int, e: Int): List[String] = {
      if (n == 0 || e > ar(n - 1)) {
        ar(n) = e
        ar.mkString(" ") :: Nil
      }
      else {
        ar(n) = ar(n - 1)
        ar.mkString(" ") :: printProcess(ar, n - 1, e)
      }
    }
    val len = arr.length - 1
    val e = arr(len)
    printProcess(arr, len, e).mkString("\n")
  }


  def main(args: Array[String]) {
    val n = readInt()
    val input = readLine().split(" ").map(_.toInt)
    println(insertionSort(input))
  }
}
