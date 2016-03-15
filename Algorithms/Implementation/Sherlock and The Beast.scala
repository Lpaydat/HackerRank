object Solution {
  
  def antiVirus(n: Int) = {
    def getWinner(list: List[(Int, Int)]) = {
      val winner = list.sorted.reverse.head
      "555" * (winner._1 / 3) + "33333" * (winner._2 / 5)
    }
    val set = for (i <- 0 to n by 3 if (n - i) % 5 == 0) yield (i, n - i)
    val list = set.toList
    list match {
      case Nil => "-1"
      case _ => getWinner(list)
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var t = sc.nextInt();
    var a0 = 0;
    while(a0 < t){
      var n = sc.nextInt();
      a0 += 1;
      println(antiVirus(n))
    }
  }
}
