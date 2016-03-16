object Solution {
  
  def canLock(s: String) = {
    val countedChar = s.groupBy(identity).mapValues(_.length).toList
    val oddChar = countedChar.count(_._2 % 2 != 0)
    if (oddChar > 1) "NO" else "YES"
  }

  def main(args: Array[String]) {
    println(canLock(readLine()))
  }
}
