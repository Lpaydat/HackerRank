object Solution {
  
  def fibonacci(n: Int, now: Long = 0, next: Long = 1): Long =
    if (n == 0) now
    else fibonacci(n - 1, next, (now + next) % 100000007l)

  def main(args: Array[String]) {
    for (i <- 1 to readInt()) println(fibonacci(readInt()))
  }
}
