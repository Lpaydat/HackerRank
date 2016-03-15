object Solution {
  
  def getFreeChoc(w: Int, m: Int): Int = {
    val free = w / m
    if (w < m) 0
    else free + getFreeChoc(free + w % m, m)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var t = sc.nextInt();
    var a0 = 0;
    while(a0 < t){
      var n = sc.nextInt();
      var c = sc.nextInt();
      var m = sc.nextInt();
      a0 += 1;
      val bought = n / c
      val choc = bought + getFreeChoc(bought, m)
      println(choc)
    }
  }
}
