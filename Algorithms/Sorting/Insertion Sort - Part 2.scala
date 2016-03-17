object Solution {
  
  def insertionSort(arr: Array[Int]): String = {
    val lastIndex = arr.length
    def recur(ar: Array[Int], n: Int): List[String] =
      if (n > lastIndex) Nil
      else (ar.take(n).sorted ++ ar.drop(n)).mkString(" ") :: recur(ar, n + 1)
    recur(arr, 2).mkString("\n")
  }

  def main(args: Array[String]) {
    val n = readInt()
    val input = readLine().split(" ").map(_.toInt)
    println(insertionSort(input))
  }
}
