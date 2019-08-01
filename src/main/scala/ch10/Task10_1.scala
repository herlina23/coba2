package ch10

//https://twitter.github.io/scala_school/basics2.html


class AddOne extends Function1[Int, Int] {
    def apply(m: Int): Int = m + 1
   }

// the function upside can be shortened by this func below

class AddOne2 extends (Int => Int) {
  def apply(m: Int): Int = m + 1
}

object Task10_1 {
  def main(args: Array[String]) {
    val plusOne = new AddOne()
    val plusOne2 = new AddOne2()
    println(plusOne(1))
    println(plusOne2(1))
  }

}
