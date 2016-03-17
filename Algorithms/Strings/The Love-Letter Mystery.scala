object Solution {
  
  def reduceToPalindrome(s: String): Int = {
    val halfLen = s.length / 2
    val zipped = s.take(halfLen) zip s.drop(halfLen).reverse
    (for (x <- zipped) yield (x._1 - x._2).abs).sum
  }

  def main(args: Array[String]) {
    val n = readInt()
    for (i <- 1 to n) println(reduceToPalindrome(readLine()))
  }
}
