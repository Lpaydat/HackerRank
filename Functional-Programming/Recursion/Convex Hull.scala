import scala.collection.mutable.ArrayBuffer

object Solution {
  // I use the "Monotone chain" algorithm for Convex Hull
  def convexHull(points: ArrayBuffer[(Int, Int)]): ArrayBuffer[(Int, Int)] = {
    def cross(o: (Int, Int), a: (Int, Int), b: (Int, Int)): Int =
      (a._1 - o._1) * (b._2 - o._2) - (a._2 - o._2) * (b._1 - o._1)

    val distinctPoints = points.distinct
    if (distinctPoints.length < 2)
      points
    else {
      val sortedPoints = distinctPoints.sorted

      val lower = ArrayBuffer[(Int, Int)]()
      for (i <- sortedPoints) {
        while (lower.length >= 2 && cross(lower(lower.length - 2), lower(lower.length - 1) , i) <= 0)
          lower -= lower.last
        lower += i
      }

      val upper = ArrayBuffer[(Int, Int)]()
      for (i <- sortedPoints.reverse) {
        while (upper.size >= 2 && cross(upper(upper.length - 2), upper(upper.length - 1) , i) <= 0)
          upper -= upper.last
        upper += i
      }

      lower -= lower.last
      upper -= upper.last
      lower ++= upper
    }
  }

  def getDistance(a: (Int,Int), b: (Int,Int)): Double =
    Math.sqrt(Math.pow((a._1 - b._1).abs, 2) + Math.pow((a._2 - b._2).abs,2))

  def getPerimeter(startPoint: (Int,Int), list: List[(Int,Int)]): Double =
    if (list.length == 1)
      getDistance(list.head, startPoint)
    else
      getDistance(list.head, list.tail.head) + getPerimeter(startPoint, list.tail)

  def main(args: Array[String]) {
    val n = readInt()
    val input = ArrayBuffer[(Int, Int)]()
    for (i <- 1 to n) {
      val arr = readLine().split(" ").map(_.toInt)
      input += ((arr(0), arr(1)))
    }
    val convexHullList = convexHull(input)
    val perimeter = getPerimeter(convexHullList.head, convexHullList.toList)
    println(perimeter)
  }
}
