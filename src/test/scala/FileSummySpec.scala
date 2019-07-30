import java.io.{File, PrintWriter}

import scala.annotation.tailrec
import org.scalatest.{FlatSpec, Matchers}

import scala.util.Random


class FileSummySpec extends FlatSpec with Matchers {

  import FileSummy._

  "The FileSummy app" should "correctly summarize a short file" in {
    val file = newFile("this is is not a test")
    val stats = buildFileStats(file)

    stats.words should equal(6)
    stats.toppies.head should equal("is")
  }

  it should "format the stats correctly" in {
    val file = newFile("this is is not a test")
    val stats = buildFileStats(file)
    val formatted = formatStats(stats)

    formatted should include ("21 chars")
    formatted should include ("6 words")
    formatted should include ("1 paragraphs")
    formatted should include (file.getName)
  }

//  let it go....!!! let it gooo!!
//  yoyooyoyo
//  yayyaya
//  naninu naninu



  it should "recognize paragraphs, ignoring non-word ones" in {
    val contents = """


    abang abang arab ganteng cuuy!! hadeh ehhheh

    """

    val file = newFile(contents)
    val stats = buildFileStats(file)
    stats.paragraphs should equal(2)
  }



//  def randomString(length: Int) = {
//    val r = new scala.util.Random
//    val sb = new StringBuilder
//    for (i <- 1 to length) {
//      sb.append(r.nextPrintableChar)
//    }
//    sb.toString
//  }

  //issue detected
  private def newFile(content: String): File = {
  //  val testFile = new File(s"summytest_${SafeStringUtils.randomLetters(20)}.txt")
  val testFile = new File(s"summytest_${Random.alphanumeric take 20 mkString}.txt")

//val testFile = new File(s"summytest_${randomString(10)}.txt")

//    Random.alphanumeric take 10 mkString

    //val testFile = new File(s"summytest_.txt")

    val writer = new PrintWriter(testFile)
    writer.write(content)
    writer.close()
    testFile
  }

}