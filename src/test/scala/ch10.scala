import org.scalatest._

class Ch10 extends FlatSpec with Matchers {

  "Ch10" should "order lines starting with right-aligned numbers" in {
    val l = List(" 2 a", " 1 b", " 3 c")

    implicit val orderingByNumber: Ordering[String] = Ordering.by(_.trim.split("\\s")(0).toInt)

    //val orderingIgnoringNumber: Ordering[String] = Ordering.by(_.trim.split("\\s")(1))

    val orderingIgnoringNumber: Ordering[String] = Ordering.by((_: String).trim.split("\\s")(1))(Ordering.String)

    Ch10.sortLines(l) should contain inOrder(" 1 b", " 2 a", " 3 c")

    Ch10.sortLines(l)(orderingIgnoringNumber) should contain inOrder(" 2 a", " 1 b", " 3 c")
  }



}