object GeeksforGeeks {

  def main(args: Array[String]) {

    // Calling the function
    println("Sum is: " + functionToAdd(5,3));
  }


  // declaration and definition of function
  def functionToAdd(a:Int, b:Int) : Int =
  {

    var sum:Int = 0
    sum = a + b

    // returning the value of sum
    return sum
  }
}