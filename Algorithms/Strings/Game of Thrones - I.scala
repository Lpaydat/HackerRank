object Solution {
  
  def isAnagram(s: String) = {
    val countedChar = s.toList.groupBy(identity).mapValues(_.size).toList
    val oddChar = countedChar.count(_._2 % 2 != 0)
    if (oddChar > 1) "NO" else "YES"
  }

  def main(args: Array[String]) {
    println(isAnagram(readLine()))
  }
}
