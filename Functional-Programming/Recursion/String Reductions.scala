object Solution {

  def addUnique(s: String, c: Char) = if (!s.contains(c)) s + c else s
  def removeDuplicate(s: String, result: String = ""): String =
    if (s == "") result
    else removeDuplicate(s.tail, addUnique(result, s.head))
  
  def main(args: Array[String]) {
    val input = io.Source.stdin.getLines().toList
    println(removeDuplicate(input.head))
  }
}
