object Solution {
  
  def excludeDifferent(a: String, b: String): Int = {
    def countChar(s: String) = s.groupBy(identity).mapValues(_.length).toList

    def getDifferent(merged: List[(Char, Int)]): List[Int] = merged match {
      case Nil => Nil
      case h :: hx :: t if h._1 == hx._1 => (h._2 - hx._2).abs :: getDifferent(t)
      case h :: t => h._2 :: getDifferent(t)
    }

    val merged = (countChar(a) ::: countChar(b)).sorted
    getDifferent(merged).sum
  }

  def main(args: Array[String]) {
    println(excludeDifferent(readLine(), readLine()))
  }
}
