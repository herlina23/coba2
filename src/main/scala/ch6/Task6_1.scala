package ch6

object Task6_1 {
  def main(args: Array[String]) {
    //1) Create a list of the first 20 odd Long numbers. Can you create this with a for-loop, with the filter operation, and with the map operation? What’s the most efficient and expressive way to write this?
    println("Chapter 6 no 1")
    println("filter")
    println(0L to 20L filter (_ % 2 == 1))
    println("map")
    println(0L to 9L map (_ * 2 + 2))

  }
}
