object Solution {
  
  def namedTopics(list: List[String]) = {
    def personKnow(topicList: List[List[Char]]): List[List[Int]] =
      if (topicList.isEmpty) Nil
      else {
        val topic = topicList.head
        val filtered = for (i <- topic.indices if topic(i) == '1') yield i
        filtered.toList :: personKnow(topicList.tail)
      }
    personKnow(list.map(_.toList))
  }

  def topTeaming(personTopics: List[List[Int]]) = {
    val sorted = personTopics.sortBy(_.length).reverse.take(100)
    sorted.combinations(2).toList.map(_.flatten.distinct)
  }

  def getWinners(combined: List[List[Int]]) = {
    val counted = combined.map(_.length)
    val maxTopics = counted.max
    val maxTeams = counted.count(_ == maxTopics)
    (maxTopics, maxTeams)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var m = sc.nextInt();
    var topic = new Array[String](n);
    for(topic_i <- 0 to n-1) {
      topic(topic_i) = sc.next();
    }
    
    val namedTopicList = namedTopics(topic.toList)
    val teams = topTeaming(namedTopicList)
    val winners = getWinners(teams)
    println(winners._1)
    println(winners._2)
  }
}
