package ch8

class Task8_2 {

}

class Listy[A](items: A*) {

  val item: Option[A] = items.headOption
  val item2 = items

  val next: Option[Listy[A]] = {
    if (item.isDefined) Some(new Listy(items.tail: _*)) else None
  }

  // jd, awalnya, kita ambil headnya
  // setelah itu, next, akan mengambil list dari Listy,
  // foreach berjalan di listy jd list baru yang digunakan sbg tail dr i-> item sbg head-nya

  //task (pemahaman code dibawah ini), per line, type
  // just show ur solution,

  def foreach(f: A => Unit): Unit = {
    for {i <- item; n <- next} {
      f(i)
      n.foreach(f)
    }
  }

  def foreach2(f: A => Unit): Unit = {
 for (i <- items  ) println(i)
  }

  // apply ini memungkinkan suatu class yg memiliki semisal 5 parameter dan dapat dipanggi hanya dengan 2 paramter

  // Scala "for comprehension" is not specific to lists, but is an extremely powerful way to operate on a List and other sequences.
  // https://alvinalexander.com/scala/iterating-scala-lists-foreach-for-comprehension

//  def apply(index: Int): Option[A] = {
//    if (index < 1) item else next flatMap (_.apply(index - 1))
//    if (index < 1) item else item
//
//  }

    def apply23(index: Int): Option[A] = {
      println("test, Input:",index)
    if (index < 1) item else item
      //if (index < 1) item else item
    }

//  def apply24(index: Int): Unit = {
//  val d =  if (index < 1) item else next
//
//    if (index.isDefined Some(apply(index))
//    else None
//    println(d)
//  }



//  def apply(index: Int): Unit = {
//    if (index < 1) items.head else items.tail
//      }

  def apply(index: Int)= {
   val d = items.apply(index)
   // println(d)
    d
  }
}

object Task8_2 {
  def main(args: Array[String]) {
    //val l = new Listy(1, 2, 3, 4)
    val l = new Listy(1, 5, 3)


    //    println(item)

    //l foreach println
    l foreach2 println
    println("=============================")
    println("=============================")

    l foreach println
    println("=============================")
    l.apply(2)

    val a = l.apply(2)
    println("print nilai a")
    println(a)
    // l apply(2)

    println("=============================")

    //println()
    // unit : tidak memberi return value, sehingga tidak dapat mengakses value untuk nilai yg lainnya atau val lainnya
    //def apply(index: Int)= {} fungsi seperti ini akan lebih accessible, dimana return value dari method tsb dapat diakses pada val lainnya
    //println diluar fungsi
  }

}