object Solution {

  def main(args: Array[String]) {
    val s = readLine().map(_.toLower)
    val alphabet = ('a' to 'z').toList
    val isPangram = if (alphabet.forall(s.contains(_))) "pangram" else "not pangram"
    println(isPangram)
  }
}
