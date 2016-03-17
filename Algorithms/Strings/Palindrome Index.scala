object Solution {
  
  def palindromeIndex(str: String): Int = {
    def removeIndex(s: String, p: Int): String = s.take(p) + s.drop(p + 1)
    def isPalindrome(s: String): Int = {
      val combined = (s zip s.reverse).toList
      combined.indexWhere(c => c._1 != c._2)
    }
    val f = isPalindrome(str)
    val s = str.length - f - 1
    (f, s) match {
      case (-1, _) => -1
      case _ => if (isPalindrome(removeIndex(str, f)) == -1) f else s
    }
  }

  def main(args: Array[String]) {
    val n = readInt()
    for (i <- 1 to n) println(palindromeIndex(readLine()))
  }
}
