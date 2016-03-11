object Solution {

  def firstCal(n: String, k: String): String = {
    val sumString = n.toList.map(_.toString.toLong).sum
    (sumString * k.toLong).toString
  }

  def superDigit(s: String): String = {
    if (s.length == 1) s
    else {
      val sd = s.toList.map(_.toString.toInt).sum.toString
      superDigit(sd)
    }
  }
  
  def main(args: Array[String]) {
    val input = readLine().split(" ").toList.map(_.toString)
    val newInput = firstCal(input.head, input(1))
    println(superDigit(newInput))
  }
}
