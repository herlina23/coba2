package ch10

object Task10_2 {



  def main(args: Array[String]) {

    def try1(as: Int*)(bs: Int*) = as.sum * bs.sum
    println("Task 10, number 2 result")
    println(try1(1)(2))
  }

}