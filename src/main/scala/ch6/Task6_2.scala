package ch6

object Task6_2 {
  def main(args: Array[String]) {
    // 2) Write a function titled "factors" that takes a number and returns a list of its factors, other than 1 and the number itself. For example, factors(15) should return List(3, 5).
    def factors(x: Int) = { 2 to (x-1) filter (x % _ == 0) }
    def uniqueFactors(l: Seq[Int]) = l flatMap factors
    println("Chapter 6 no 2")
    println(uniqueFactors(List(9, 11, 13, 15)))
    println()
  }

}
