//package ch8
//
//
//
//class ListyHelper {
//  def create[A](items: A*) = {
//    var result: Listy[A] = new EmptyList[A]
//    for (item <- items.reverse) {
//      result = new NonEmptyList[A](item, result)
//    }
//    result
//  }
//}
//
//abstract class Listy[A] {
//  def foreach(f: A => Unit): Unit
//  def apply(index: Int): Option[A]
//
//  def headOption: Option[A] = apply(0)
//}
//
//class NonEmptyList[A](val item: A, val next: Listy[A]) extends Listy[A] {
//
//  override def foreach(f: A => Unit): Unit = {
//    f(item)
//    next.foreach(f)
//  }
//
//  override def apply(index: Int): Option[A] = {
//    if (index < 1) Some(item) else next.apply(index - 1)
//  }
//}
//
//class EmptyList[A] extends Listy[A] {
//  override def foreach(f: A => Unit): Unit = {}
//  override def apply(index: Int): Option[A] = None
//}
//
//object Task8_2b {
//  def main(args: Array[String]) {
//    val l = List(1,2,3,4)
//    val r = new EmptyList[l]
//
//
//    }
//
//}