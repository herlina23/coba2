package ch4

object Task4_1 {
  def main(args: Array[String]) {
    // 1) Write a function that computes the area of a circle given its radius.
    def lingkaran (r:Double) :Double = r*r*3.14;

    def lingkaran2 (r:Double) :Double = math.pow(r,2)* math.Pi;

    println("Chapter 4 no 1")
    println(lingkaran(7))
    println(lingkaran2(7))

  }

}
