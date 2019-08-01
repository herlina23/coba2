package ch7

object Task7a {


  def main(args: Array[String]) {

    // accessing the data from api, in xml format
    val url = "http://api.openweathermap.org/data/2.5/forecast?mode=xml&lat=55&lon=0&APPID=f8c2705abbe43a56eaca373e8d86070e"

    var json = "http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=f8c2705abbe43a56eaca373e8d86070e"

    //make the xml parse to list of string
    val l: List[String] = io.Source.fromURL(url).getLines.toList

    val br = io.Source.fromURL(url).getLines.mkString

    val jn = io.Source.fromURL(json).getLines.mkString



    // mapping and trim
    //make parsing easier, trim that white space from each line
    val k = l map (_.trim)

    //Measuring the number of lines
    val segments = k.filter(_ contains "</time>").size

    def getChild(tag: String) = k filter (_ contains s"<$tag>") mkString "" replaceAll(".*>(\\w+)</.*","$1")


    val cityName = getChild("name")


    val countryCode = getChild("country")


    //retrieve the contents of the "name"
    def attribute(tag: String, attr: String) = {
      k.filter(_ contains s"<$tag")
        .filter(_ contains s"$attr=")
        .map { s => s.replaceAll(s""".*$attr="([^"]+)".*""", "$1") }
    }

    val names = attribute("symbol", "name")
    val forecast = attribute("time", "from") zip attribute("symbol", "name") take 4
    val terms = attribute("symbol", "name").distinct.sorted

    val symbolsToDescriptions = attribute("symbol", "number") zip attribute("symbol", "name")
    val symMap = symbolsToDescriptions.distinct.map(t => t._1.toInt -> t._2).toMap
    val maxC = attribute("temperature", "max").map(_.toDouble).max
    val minC = attribute("temperature", "min").map(_.toDouble).min
    val temps = attribute("temperature", "value").map(_.toDouble)
    val avgC = temps.sum / temps.size


    println("########################")
    println(l)
    println("########################")
    println(segments)
    println("########################")
    println(names)
    println("########################")
    println(forecast)
    println("########################")
    println(cityName)
    println(countryCode)

    {
         println("12 hour forecast")
         forecast foreach { case (time, desc) =>
             val when = time.replaceAll("""T(\d+).*""",""" at $100""")
             println(s"$when | $desc")
           }
       }
    println("########################")
    println(symbolsToDescriptions)
    println("########################")
    println(symMap)
    println("########################")
    println(maxC)
    println("########################")
    println(minC)
    println("########################")
    println(avgC)


  }

}
