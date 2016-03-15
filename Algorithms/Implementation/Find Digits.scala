object Solution {
  
  def findDigits(n: Int) = {
    val splitNums = n.toString.map(_.toString.toInt).filterNot(_ == 0)
    splitNums.count(n % _ == 0)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var t = sc.nextInt();
    var a0 = 0;
    while(a0 < t){
      var n = sc.nextInt();
      a0 += 1;
      println(findDigits(n))
    }
  }
}
