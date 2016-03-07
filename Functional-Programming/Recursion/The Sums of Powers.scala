object Solution {
    
  def sumsOfPowers(target: Int, power: Int): Int = {
    def candidates(n: Int = 1): List[Int] = {
      def powers(power: Int): Int = if (power == 0) 1 else n * powers(power - 1)
      val powered = powers(power)
      if (powered > target) Nil
      else powered :: candidates(n + 1)
    }
    
    // create all possible groups from candidates list
    def grouping(candidates: List[Int], set: List[List[Int]] = List(List(0))): List[List[Int]] = {
      if (candidates.isEmpty || set.isEmpty) List(List())
      else {
        val newSet = for {
          head <- candidates
          inSet <- set
          if inSet.sum + head <= target && inSet.max < head
        } yield head :: inSet
        newSet ::: grouping(candidates.tail, newSet)
      }
    }
    
    grouping(candidates()).count(_.sum == target)
  }

  def main(args: Array[String]) {
     println(sumsOfPowers(readInt(),readInt()))
  }
}
