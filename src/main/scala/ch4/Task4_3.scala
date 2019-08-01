package ch4

object Task4_3 {
  def main(args: Array[String]) {
    //3) Write a recursive function that prints the values from 5 to 50 by fives, without using for or while loops. Can you make it tail-recursive?
    @annotation.tailrec
    def fives(cur: Int, max: Int): Unit = {
      if (cur <= max) {
        println(cur)
        fives(cur + 5, max)
      }
    }

    println("Chapter 4 no 3")
    println(fives(0, 20))
    println()
  }

}
