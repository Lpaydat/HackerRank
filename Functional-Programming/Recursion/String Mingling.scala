object Solution {

  def mixString(x: String, y: String): String =
    (x zip y).map(z => z._1.toString + z._2.toString).mkString
  
  def main(args: Array[String]) {
    val input = io.Source.stdin.getLines().toList.map(_.toString)
    println(mixString(input(0), input(1)))
  }
}
