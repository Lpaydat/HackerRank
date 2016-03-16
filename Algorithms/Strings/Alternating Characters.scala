object Solution {

  def deletingCount(s: String) = {
    var n = 0
    for (i <- s.indices if i > 0 && s(i) == s(i - 1)) n += 1
    n
  }
  
  def main(args: Array[String]) {
    var tc = readInt()
    for (i <- 1 to tc) println(deletingCount(readLine()))
  }
}
