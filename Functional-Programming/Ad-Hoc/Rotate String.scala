object Solution {
  
  def allRotate(s: String, n: Int): String = {
    def rotate(h: String, t: String): String =
      if (t == "") h else t.head + rotate(h, t.tail)

    if (n == 0) ""
    else {
      val rotated = rotate(s.head.toString, s.tail)
      rotated +" "+ allRotate(rotated, n - 1)
    }
  }

  def main(args: Array[String]) {
    val input = io.Source.stdin.getLines().toList.drop(1).map(_.toString)
    input.foreach(s => println(allRotate(s, s.length)))
  }
}
