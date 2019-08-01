package ch5

object Task5_3 {
  def main(args: Array[String]) {
    // 3) Write a higher-order function that takes an integer and returns a function. The returned function should take a single integer argument (say, "x") and return the product of x and the integer passed to the higher-order function.
    def multy(x: Int) = (y: Int) => x * y;
    var tripler = multy(3);

    println("Chapter 5 no 3")
    println(tripler(10))

  }
}
