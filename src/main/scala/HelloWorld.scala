

object HelloWorld {

  // Chapter 1
  // 2) In the Scala REPL, convert the temperature value of 22.5 Centigrade to Fahrenheit. The conversion formula is cToF(x) = (x * 9/5) + 32.
  // 3) Take the result from exercise 2, half it, and convert it back to Centigrade. You can use the generated constant variable (e.g. "res0") instead of copying and pasting the value yourself.
  val a = (22.5 * 9 / 5 + 32);

  //Chapter 2
  // 1) Write a new centigrade-to-fahrenheit conversion (using the formula (x * 9/5) + 32), saving each step of the conversion into separate values. What do you expect the type of each value will be?
  val c = 7;
  val f1 = c*9;
  val f2 = f1/5.0;
  val frheit = f2+32;

  // 2) Modify the centigrade-to-fahrenheit formula to return an integer instead of a floating-point number.

  //Chapter 3
  // 1) Given a string name, write a match expression that will return the same string if non-empty, or else the string "n/a" if it is empty.
  val name = "";

  // 2) Given a double amount, write an expression to return "greater" if it is more than zero, "same" if it equals zero, and "less" if it is less than zero. Can you write this with if..else blocks? How about with match expressions?
  val amount = 3;

  // Chapter 4
  // 1) Write a function that computes the area of a circle given its radius.
  def lingkaran (r:Double) :Double = r*r*3.14;
  def lingkaran2 (r:Double) :Double = math.pow(r,2)* math.Pi;

  //3) Write a recursive function that prints the values from 5 to 50 by fives, without using for or while loops. Can you make it tail-recursive?
  @annotation.tailrec
  def fives(cur: Int, max: Int): Unit = {
    if (cur <= max) {
      println(cur)
      fives(cur + 5, max)
    }
  };

  // Chapter 5
  // 3) Write a higher-order function that takes an integer and returns a function. The returned function should take a single integer argument (say, "x") and return the product of x and the integer passed to the higher-order function.
  def multy(x: Int) = (y: Int) => x * y;
  var tripler = multy(3);

  //  5) There’s a function named "square" that you would like to store in a function value. Is this the right way to do it? How else can you store a function in a value?
  //  def square(m: Double) = m * m
  //  val sq = square
  def square (m:Double) = m*m;
  val sq = square _;

  // Chapter 6
  //1) Create a list of the first 20 odd Long numbers. Can you create this with a for-loop, with the filter operation, and with the map operation? What’s the most efficient and expressive way to write this?


  // 2) Write a function titled "factors" that takes a number and returns a list of its factors, other than 1 and the number itself. For example, factors(15) should return List(3, 5).
  def factors(x: Int) = { 2 to (x-1) filter (x % _ == 0) }
  def uniqueFactors(l: Seq[Int]) = l flatMap factors

  //chapter 7

  // 4) Write a function to return the product of two numbers.. that are each specified as a String, not a numeric type. Will you support both integers and floating-point numbers? How will you convey if either or both of the inputs are invalid? Can you handle the converted numbers using a match expression? How about with a for-loop?
  def toDouble(a: String) = util.Try(a.toDouble).toOption;

  def product(a: String, b: String): Option[Double] = {
    for (a1 <- toDouble(a); b1 <- toDouble(b)) yield a1 * b1
  }
  val x = product("yes", "20")
  val y = product("99.3", "7")




  // running env
  def main(args: Array[String]) {
    println("Chapter 1 no 2")
    println(22.5 * 9 / 5 + 32)

    println("Chapter 1 no 3")
    println((a - 32) * 5 / 9)

    println("Chapter 2 no 1")
    println(c)
    println(f1)
    println(f2)
    println(frheit)

    println("Chapter 2 no 2")
    println(c)
    println(f1)
    println(f2)
    println(frheit.toInt)

    println("Chapter 3 no 1")
    println(name match {
      case "" => "n/a"
      case n => n
    })

    println("Chapter 3 no 2")
    println("if-else")
    println(if (amount > 0) "greater" else if (amount < 0) "lesser" else "same")
    println("match")
    println(
      amount match {
        case x if x > 0 =>"greater"
        case x if x < 0 =>"lesser"
        case x => "same"

      }
    )

    println("Chapter 4 no 3")
    println(lingkaran(7))
    println(lingkaran2(7))

    println("Chapter 4 no 3")
    println(fives(0, 20))

    println("Chapter 5 no 3")
    println(tripler(10))

    println("Chapter 5 no 3")
    println(sq(4.0))

    println("Chapter 6 no 1")
    println("filter")
    println(0L to 20L filter (_ % 2 == 1))
    println("map")
    println(0L to 9L map (_ * 2 + 2))

    println("Chapter 6 no 2")
    println(uniqueFactors(List(9, 11, 13, 15)))

    println("Chapter 7 no 4")
    println(x)
    println(y)

//    println("Chapter 7 no 6")
//    println(uniqueFactors(List(9, 11, 13, 15)))

  }}



