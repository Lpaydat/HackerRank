object Solution {
  
  def commonDivisor(a: Int, b: Int) = {
    def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
    def getCD(n: Int, ls: List[Int], cdList: List[Int] = Nil): List[Int] = ls match {
      case Nil => cdList
      case h :: t => h :: t match {
        case _ if n % h == 0 => getCD(n, t, h :: n / h :: cdList)
        case _ => getCD(n, t, cdList)
      }
    }
    val g = gcd(a, b)
    val listInt = (1 to Math.sqrt(g).toInt).toList
    getCD(g, listInt).distinct.length
  }

  def main(args: Array[String]) {
    val n = readInt()
    val input = for (i <- 1 to n) yield readLine().split(" ").toList.map(_.toInt)
    input.foreach(x => println(commonDivisor(x(0),x(1))))
  }
}
