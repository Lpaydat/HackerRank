object Solution {
  
  def cutSticks(sticks: List[Int], countList: List[Int] = Nil): String = {
    if (sticks.isEmpty) countList.reverse.mkString("\n")
    else {
      val shortestStick = sticks.min
      val newSticksList = sticks.map(_ - shortestStick).filter(_ > 0)
      cutSticks(newSticksList, sticks.length :: countList)
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var arr = new Array[Int](n);
    for (arr_i <- 0 to n-1) {
      arr(arr_i) = sc.nextInt();
    }
    val sticks = arr.toList
    println(cutSticks(sticks))
  }
}
