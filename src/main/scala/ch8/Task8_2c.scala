//package ch8
//
//class Task8_2c {
//
//}
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
//
//  lazy val head: A = headOption.get
//
//  def tail: Listy[A]
//  lazy val reverse: Listy[A] = {
//    var result: Listy[A] = new EmptyList[A]
//    foreach { i => result = new NonEmptyList[A](i, result) }
//    result
//    //result.reverse
//  }
//
//  def filter(f: A => Boolean): Listy[A] = {
//    var result: Listy[A] = new EmptyList[A]
//    foreach { i =>
//      if ( f(i) ) {
//        result = new NonEmptyList[A](i, result)
//      }
//    }
//    result
//    //result.reverse
//    //result.reverse
//  }
//
//  lazy val size: Int = {
//    var count = 0
//    foreach { _ => count += 1 }
//    count
//  }
//
//  def map[B](f: A => B): Listy[B] = {
//    var result: Listy[B] = new EmptyList[B]
//    foreach { i =>
//      result = new NonEmptyList[B](f(i), result)
//    }
//    //result.reverse
//    result
//  }
//
//}
//
//class NonEmptyList[A](val item: A, val tail: Listy[A]) extends Listy[A] {
//
//  override def foreach(f: A => Unit): Unit = {
//    f(item)
//    tail.foreach(f)
//  }
//
//  override def apply(index: Int): Option[A] = {
//    if (index < 1) Some(item) else tail.apply(index - 1)
//  }
//}
//
//class EmptyList[A] extends Listy[A] {
//  override def foreach(f: A => Unit): Unit = {}
//  override def apply(index: Int): Option[A] = None
//  //override def tail: Listy[A] = null
//}
