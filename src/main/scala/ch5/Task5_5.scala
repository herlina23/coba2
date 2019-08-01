package ch5

object Task5_5 {

  def main(args: Array[String]) {

    //  5) There’s a function named "square" that you would like to store in a function value. Is this the right way to do it? How else can you store a function in a value?
    //  def square(m: Double) = m * m
    //  val sq = square
    def square (m:Double) = m*m;
    val sq = square _;

    println("Chapter 5 no 5")
    println(sq(4.0))

  }

}
