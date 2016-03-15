object Solution {

  def findCavity(n: Int, arr: Array[String]) = {
    def isBorder(mapSize: Int, row: Int, col: Int) =
      row == 0 || col == 0 || row == mapSize - 1 || col == mapSize - 1
    val xPositions = for {
      row <- 0 until n
      col <- 0 until n
    } yield {
      val center = arr(row)(col)
      val adjacent = {
        if (isBorder(n, row, col)) List(9)
        else List(arr(row - 1)(col), arr(row + 1)(col), arr(row)(col - 1), arr(row)(col + 1)).map(_.toString.toInt)
      }
      if (center.toString.toInt > adjacent.max) "X" else center
    }
    xPositions.toList.sliding(n, n).map(_.mkString).mkString("\n")
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var grid = new Array[String](n);
    for(grid_i <- 0 to n-1) {
      grid(grid_i) = sc.next();
    }
    val marked = findCavity(n, grid)
    println(marked)
  }
}
