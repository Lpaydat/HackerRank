object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    for (i <- 1 to n) println(" " * (n - i) + "#" * i)
  }
}
