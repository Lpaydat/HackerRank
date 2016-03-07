object Solution {
  
  def getPossibilitis(n: Int, k: Int): Long = {
    def primesUpTo(n: Int) = {
      val isPrime = collection.mutable.BitSet(2 to n: _*) -- (4 to n by 2)
      for (p <- 2 +: (3 to Math.sqrt(n).toInt by 2) if isPrime(p))
        isPrime --= p * p to n by p
      isPrime.toList
    }
    val primes = primesUpTo(1000)
    def factorialList(n: Int, m: Int = 0): List[Int] = (n, m) match {
      case (1, 1) => List(1, 1)
      case (1, 0) => List(1)
      case (1, _) => m :: factorialList(1, m - 1)
      case (_, _) => n :: factorialList(n - 1, m)
    }
    def getPrimeFactor(ls: List[Int]): List[Int] = {
      def extractInt(i: Int, p: List[Int] = primes): List[Int] = i match {
        case 1 => Nil
        case _ if i % p.head == 0 => p.head :: extractInt(i / p.head, primes)
        case _ => extractInt(i, p.tail)
      }
      ls match {
        case Nil => Nil
        case h :: t => extractInt(h) ::: getPrimeFactor(t)
      }
    }
    def groupDuplicates(ls: List[Int]): List[(Int, Int)] = ls.groupBy(identity).mapValues(_.size).toList
    def removeDuplicates(up: List[(Int, Int)], dn: List[(Int, Int)]): List[Long] = {
      def unzip(n: Int, m: Int): List[Int] = (for (i <- 1 to m) yield n).toList
      val noDuplicates = for {
        u <- up
        d <- dn
        if u._1 == d._1 && u._2 > d._2
      } yield unzip(u._1, (u._2 - d._2).abs)
      noDuplicates.flatten.sortWith(_ > _).map(_.toLong)
    }
    def getModRemain(ls: List[Long]): Long =
      if (ls.isEmpty) 1
      else (ls.head * getModRemain(ls.tail)) % 100000007
    
    if (k == 0 || k == n) 1 else {
      val up = getPrimeFactor(factorialList(n))
      val down = getPrimeFactor(factorialList(k, n - k))
      val groupUp = groupDuplicates(up)
      val groupDown = groupDuplicates(down)
      val upUnique = up.filterNot(down.toSet).map(_.toLong)
      val smallList = upUnique ::: removeDuplicates(groupUp, groupDown)
      getModRemain(smallList)
    }
  }

  def main(args: Array[String]) {
    val input = io.Source.stdin.getLines().drop(1).map(_.split(" ").map(_.toInt).toList).toList
    input.foreach(x => println(getPossibilitis(x.head, x(1))))
  }
}
