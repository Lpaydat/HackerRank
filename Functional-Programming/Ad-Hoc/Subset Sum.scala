object Solution {
  // I cannot solve this problem by using List, need to uses Array and binary search.
  def minSubset(testCases: List[Long], arr: Array[Long]) = {
    def binarySearch(n: Long, ls: Array[Long], min: Int, max: Int): Int = {
      if (min < max) {
        val mid = min + ((max - min) >> 1)
        if (n > ls(mid)) binarySearch(n, ls, mid + 1, max)
        else binarySearch(n, ls, min, mid)
      } else min
    }
    val total = arr.sum
    val len = arr.length
    val sortedArr = arr.sortWith(_ > _)
      for (i <- sortedArr.indices if i != 0) sortedArr(i) += sortedArr(i - 1)
    val result = for (tc <- testCases) yield if (total < tc) -1 else binarySearch(tc, sortedArr, 0, len) + 1
    result.mkString("\n")
  }

  def main(args: Array[String]) {
    val input = io.Source.stdin.getLines().drop(1).toList
    val arr = input.head.split(" ").map(_.toLong)
    val testCases = input.drop(2).map(_.toLong)
    println(minSubset(testCases, arr))
  }
}
