package ch2

object Task2_2 {
  def main(args: Array[String]) {

    // 2) Modify the centigrade-to-fahrenheit formula to return an integer instead of a floating-point number.
    val c = 7
    val f1 = c * 9
    val f2 = f1 / 5.0
    val frheit = f2 + 32

    println("Chapter 2 no 2")
    println(c)
    println(f1)
    println(f2)
    println(frheit.toInt)

  }
}
