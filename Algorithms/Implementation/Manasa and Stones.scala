object Solution {

  def getLastStone(n: Int, a: Int, b: Int): String = {
    val start = a.min(b) * (n - 1)
    val end = b.max(a) * (n - 1)
    val increase = (b - a).abs
    def compute(acc: Int): List[Int] =
      if (acc == end) acc :: Nil
      else acc :: compute(acc + increase)
    compute(start).mkString(" ")
  }
  
  def main(args: Array[String]) {
    val input = io.Source.stdin.getLines().drop(1).map(_.toInt).sliding(3, 3)
    input.foreach(x => println(getLastStone(x(0), x(1), x(2))))
  }
}
