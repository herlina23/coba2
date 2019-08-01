package ch7

object Task7_6 {
  def main(args: Array[String]) {
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

    println("chapter 7 no 6")
    println(slickReport)

  }

}
