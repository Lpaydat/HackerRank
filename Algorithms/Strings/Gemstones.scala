object Solution {
  
  def findGemStones(stones: List[String]) = {
    val charList = stones.flatten.distinct
    charList.count(char => stones.forall(_.contains(char)))
  }

  def main(args: Array[String]) {
    val n = readInt()
    val stones = (for (i <- 1 to n) yield readLine()).toList
    println(findGemStones(stones))
  }
}
