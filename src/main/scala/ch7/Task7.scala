
package tu1

object Task7 {
  //answer no 4
  //4) Write a function to return the product of two numbers.. that are each specified as a String, not a numeric type. Will you support both integers and floating-point numbers? How will you convey if either or both of the inputs are invalid? Can you handle the converted numbers using a match expression? How about with a for-loop?
  def toDouble(a: String) = util.Try(a.toDouble).toOption;

  def product(a: String, b: String): Option[Double] = {
    for (a1 <- toDouble(a); b1 <- toDouble(b)) yield a1 * b1
  }
  val x = product("yes", "20")
  val y = product("99.3", "7")

  //answer no 6

  val u = "https://github.com/scala/scala/commits/2.11.x.atom"

  val s = io.Source.fromURL(u)

  val text = s.getLines.map(_.trim).mkString("")

  def githubRss(user: String, repo: String, branch: String): String = {
    val url = s"https://github.com/$user/$repo/commits/$branch.atom"
    val lines = io.Source.fromURL(url).getLines.toList
    val xml = lines.map(_.trim).mkString("")
    xml
  }
  val xml = githubRss("slick", "slick", "master")
  def xmlToEntryList(xml: String) = xml.split("</?entry>").filterNot(_.isEmpty).tail //yg kosong dibuang
  val entries = xmlToEntryList(xml); println(s"Got ${entries.size} entries")

  def child(xml: String, name: String): Option[String] = {
    val p = s".*<$name>(.*)</$name>.*".r
    xml match {
      case p(result) => Option(result)
      case _ => None
    }
  }
  val firstTitle = child(entries(0), "title")

  def report(entryXml: String): Option[String] = {
    for {
      title <- child(entryXml, "title")
      date <- child(entryXml, "updated").map(_.replaceAll("T.*",""))
      author <- child(entryXml, "name")
    }
      yield s"title:  $title\ndate:   $date\nauthor: $author"
  }
  val firstReport = report(entries(0))
  def getGithubReport(user: String, repo: String, branch: String): String = {
    val xml = githubRss(user, repo, branch)

    val entries = xmlToEntryList(xml).toList

    val formattedEntries = entries flatMap report
    val title = s"Github commit activity for $repo:$branch"
    title :: formattedEntries mkString ("\n" + "=" * 80 + "\n")
  }
  val slickReport = getGithubReport("slick", "slick", "master")

  def main(args: Array[String]) {
    println("Chapter 7 no 4")
    println(x)
    println(y)
    println("chapter 7 no 6")
    println(slickReport)
  }

}