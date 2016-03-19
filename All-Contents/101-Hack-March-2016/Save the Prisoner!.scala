object Solution {
  
  def warn(n: Int, m: Int, s: Int): Int = {
    val x = (s + m - 1) % n
    if (x == 0) n else x
  }

  def main(args: Array[String]) {
    def t = readInt()
    def input = for (i <- 1 to t) yield readLine().split(" ").map(_.toInt)
    input.foreach(x => println(warn(x(0),x(1),x(2))))
  }
}
