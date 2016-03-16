object Solution {
  
  def getKaprekerList(p: Int, q: Int): String = {
    def isKapreker(n: Int): Boolean = {
      val powered = 1L * n * n
      val s = powered.toString
      val len = s.length / 2
      val kn = s.take(len).toInt + s.drop(len).toInt
      kn == n
    }
    def buildKaprekerList(n: Int, kaprekerList: List[Int] = Nil): List[Int] = n match {
      case _ if n <= 1 && q > 3 => buildKaprekerList(4, 1 :: kaprekerList)
      case _ if n < 4 => buildKaprekerList(4, kaprekerList)
      case _ if n > q => kaprekerList.reverse
      case _ if isKapreker(n) => buildKaprekerList(n + 1, n :: kaprekerList)
      case _ => buildKaprekerList(n + 1, kaprekerList)
    }
    val result = buildKaprekerList(p)
    if (result.isEmpty) "INVALID RANGE" else result.mkString(" ")
  }

  def main(args: Array[String]) {
    val p = readInt()
    val q = readInt()
    println(getKaprekerList(p, q))
  }
}
