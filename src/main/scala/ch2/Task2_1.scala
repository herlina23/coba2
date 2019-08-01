package ch2

object Task2_1 {

  def main(args: Array[String]) {
    // 1) Write a new centigrade-to-fahrenheit conversion (using the formula (x * 9/5) + 32), saving each step of the conversion into separate values. What do you expect the type of each value will be?
    val c = 7
    val f1 = c * 9
    val f2 = f1 / 5.0
    val frheit = f2 + 32

    println("Chapter 2 no 1")
    println(c)
    println(f1)
    println(f2)
    println(frheit)
  }

}
