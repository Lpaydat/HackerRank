object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var a = Array.ofDim[Int](n,n);
    for (a_i <- 0 to n-1) {
      for (a_j <- 0 to n-1){
        a(a_i)(a_j) = sc.nextInt();
      }
    }
    val x = for {
      i <- a.indices
      j <- a(i).indices
      if i == j
    } yield a(i)(j)
    val y = for {
      i <- a.indices
      j <- a(i).indices
      if i + j == n - 1
    } yield a(i)(j)
      
    println((x.sum - y.sum).abs)
  }
}
