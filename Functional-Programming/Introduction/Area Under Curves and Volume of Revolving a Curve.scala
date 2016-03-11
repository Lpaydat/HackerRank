  def fx(coefficients: List[Int], powers: List[Int], x: Double): Double =
    if (coefficients.isEmpty || powers.isEmpty) 0
    else coefficients.head * Math.pow(x, powers.head) + fx(coefficients.tail, powers.tail, x)

  def f(coefficients: List[Int], powers: List[Int], x: Double): Double =
    0.001 * fx(coefficients, powers, x)

  def area(coefficients: List[Int], powers: List[Int], x: Double): Double =
    0.001 * Math.PI * Math.pow(fx(coefficients, powers, x), 2)

  def summation(
       func: (List[Int], List[Int], Double) => Double,
       upperLimit: Int,
       lowerLimit: Int,
       coefficients: List[Int],
       powers: List[Int]
     ): Double = {
    def compute(a: Double, b: Double): Double =
      if (a > b) 0
      else func(coefficients, powers, a) + compute(a + 0.001, b)
    compute(lowerLimit, upperLimit)
  }
