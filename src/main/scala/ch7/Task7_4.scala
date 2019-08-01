package ch7

object Task7_4 {
  def main(args: Array[String]) {
    // 4) Write a function to return the product of two numbers.. that are each specified as a String, not a numeric type. Will you support both integers and floating-point numbers? How will you convey if either or both of the inputs are invalid? Can you handle the converted numbers using a match expression? How about with a for-loop?
    def toDouble(a: String) = util.Try(a.toDouble).toOption;

    def product(a: String, b: String): Option[Double] = {
      for (a1 <- toDouble(a); b1 <- toDouble(b)) yield a1 * b1
    }
    val x = product("yes", "20")
    val y = product("99.3", "7")
    println("Chapter 7 no 4")
    println(x)
    println(y)
  }
}
