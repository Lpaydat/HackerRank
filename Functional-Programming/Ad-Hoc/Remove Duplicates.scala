object Solution {

  def rd(s: String, fil: String = ""): String = s match {
    case "" => fil
    case _ if !fil.contains(s.head) => rd(s.tail, fil + s.head)
    case _ => rd(s.tail, fil)
  }
  
  def main(args: Array[String]) {
    println(rd(readLine()))
  }
}
