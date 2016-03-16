object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var t = sc.nextInt();
    var a0 = 0;
    while(a0 < t){
      var b = sc.nextInt();
      var w = sc.nextInt();
      var x = sc.nextInt();
      var y = sc.nextInt();
      var z = sc.nextInt();
      a0 += 1;
      
      val b2w = y + z
      val w2b = x + z
      val realBlackCost = (if (x < b2w) x else b2w) * 1L
      val realWhiteCost = (if (y < w2b) y else w2b) * 1L
      println(b * realBlackCost + w * realWhiteCost)
    }
  }
}
