object Solution {
    
  def sumsOfPowers(target: Int, power: Int): Int = {
    def candidates(n: Int = 1): List[Int] = {
      def powers(power: Int): Int = if (power == 0) 1 else n * powers(power - 1)
      val powered = powers(power)
      if (powered > target) Nil
      else powered :: candidates(n + 1)
    }
    
    // create all possible groups from candidates list
    def grouping(candidates: List[Int], grouped: List[List[Int]] = List(List(0))): List[List[Int]] = {
      if (candidates.isEmpty || grouped.isEmpty) List(List())
      else {
        val newGroup = for {
          head <- candidates
          someGroup <- grouped
          if someGroup.sum + head <= target && someGroup.max < head // if summed is not exceed and head is not exists in group
        } yield head :: someGroup // added candidates.head to the groups that still in condition
        newGroup ::: grouping(candidates.tail, newGroup) // do it again with the next number in candidates list
      }
    }
    
    grouping(candidates()).count(_.sum == target)
  }

  def main(args: Array[String]) {
     println(sumsOfPowers(readInt(),readInt()))
  }
}
