package ch10

object Task10 {

  def try1(as: Int*)(bs: Int*) = as.sum * bs.sum

  def main(args: Array[String]) {
    println("Task 10, number 2 result")
    println(try1(1)(2))
  }

}