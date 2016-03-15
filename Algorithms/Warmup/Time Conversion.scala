object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var time = sc.next();
    val hour = time.take(2)
    val ampmTime = time.take(8)
    val ampm = time.drop(8)
      
    val convertedTime = (hour, ampm) match {
      case ("12", "AM") => "00"+ ampmTime.drop(2)
      case ("12", "PM") => "12"+ ampmTime.drop(2)
      case (_, "AM") => ampmTime
      case (_, "PM") => (hour.toInt + 12) + ampmTime.drop(2)
    }
    println(convertedTime)
  }
}
