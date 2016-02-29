object Solution {
    
  def fibonacci(n: Int, now: Int = 0, next: Int = 1): Int =
    if (n == 1) now
    else fibonacci(n - 1, next, next + now)

  def main(args: Array[String]) {
    println(fibonacci(readInt()))
  }
}
