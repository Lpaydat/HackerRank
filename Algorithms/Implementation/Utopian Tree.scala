object Solution {
  
  def utopianHeight(n: Int, cycles: Int = 0, height: Int = 1):Int = (cycles, height) match {
    case (c, _) if c == n => height
    case (c, _) if c % 2 == 0 => utopianHeight(n, cycles + 1, height * 2)
    case _ => utopianHeight(n, cycles + 1, height + 1)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var t = sc.nextInt();
    var a0 = 0;
    while(a0 < t){
      var n = sc.nextInt();
      a0 += 1;
      println(utopianHeight(n))
    }
  }
}
