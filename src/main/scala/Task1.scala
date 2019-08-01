object Task1 {

  val u = "https://github.com/scala/scala/commits/2.11.x.atom"

  val s = io.Source.fromURL(u)

   val text = s.getLines.map(_.trim).mkString("")


  def main(args: Array[String]) {
    println()
  }

}