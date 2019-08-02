package ch8

class Task8_2 {

}

class Listy[A](items: A*) {

  val item: Option[A] = items.headOption

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

//  def foreach2(f: A => Unit): Unit = {
//    for {i <- A} {
//
//
//    }
//  }
//  def foreach2(f: A => Unit): Unit = {
//    f foreach
//  }

  //val fr = item.foreach(A=>Unit)

//  def apply(index: Int): Option[A] = {
//    if (index < 1) item else next flatMap (_.apply(index - 1))
//  }
}

object Task8_2 {
  def main(args: Array[String]) {
    val l = new Listy(1, 2, 3, 4)

//    println(item)

    l foreach println

   //println()
  }

}