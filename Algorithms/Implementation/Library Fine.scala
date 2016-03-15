object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var d1 = sc.nextInt();
    var m1 = sc.nextInt();
    var y1 = sc.nextInt();
    var d2 = sc.nextInt();
    var m2 = sc.nextInt();
    var y2 = sc.nextInt();
    
    val fine = (d1, m1, y1, d2, m2, y2) match {
      case _ if y1 > y2 => 10000
      case _ if y1 == y2 && m1 > m2 => (m1 - m2) * 500
      case _ if y1 == y2 && m1 == m2 && d1 > d2 => (d1 - d2) * 15
      case _ => 0
    }
    println(fine)
  }
}
