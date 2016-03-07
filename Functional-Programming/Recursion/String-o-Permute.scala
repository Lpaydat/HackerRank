object Solution {
  
  def swapOddEven(s: String): String = {
    val newString = for (i <- s.indices) yield
      if (i % 2 == 0) s(i + 1) else s(i - 1)
    newString.mkString
  }

  def main(args: Array[String]) {
    val input = io.Source.stdin.getLines().toList.drop(1).map(_.toString)
    input.foreach(x => println(swapOddEven(x)))
  }
}
