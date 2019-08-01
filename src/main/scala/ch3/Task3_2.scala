package ch3

object Task3_2 {
  def main(args: Array[String]) {
    // 2) Given a double amount, write an expression to return "greater" if it is more than zero, "same" if it equals zero, and "less" if it is less than zero. Can you write this with if..else blocks? How about with match expressions?
    val amount = 3;


    println("Chapter 3 no 2")
    println("if-else")
    println(if (amount > 0) "greater" else if (amount < 0) "lesser" else "same")
    println("match")
    println(
      amount match {
        case x if x > 0 =>"greater"
        case x if x < 0 =>"lesser"
        case x => "same"

      }
    )
    println()
  }

}
