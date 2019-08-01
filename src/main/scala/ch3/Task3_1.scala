package ch3

object Task3_1 {
  def main(args: Array[String]) {
    // 1) Given a string name, write a match expression that will return the same string if non-empty, or else the string "n/a" if it is empty.
    val name = "";

    println("Chapter 3 no 1")
    println(name match {
      case "" => "n/a"
      case n => n
    })

  }

}
