def f(x: Float, n: Int = 10): Float = {
  def factorial(n: Int): Float = if (n == 1) 1.0f else n * factorial(n - 1)
  def power(n: Int): Float = if (n == 0) 1.0f else x * power(n - 1)
  def valueAtN(n: Int): Float = power(n) / factorial(n)

  if (n == 1) 1 else valueAtN(n - 1) + f(x, n - 1)
}
