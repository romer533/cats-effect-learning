package com.hivetaxi.part.second

import cats.Monoid
import cats.implicits.catsKernelStdGroupForDouble
import cats.kernel.Semigroup
import cats.syntax.semigroup._

object Main extends App {

  // Part 2 for book Scala with Cats
  // Monoids and Semigroups

  // The truth about monoids
  implicit val monoidForAndBoolean: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean = true
    override def combine(x: Boolean, y: Boolean): Boolean = x && y
  }

  implicit val monoidForOrBoolean: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean = false
    override def combine(x: Boolean, y: Boolean): Boolean = x || y
  }

  implicit val monoidForEitherBoolean: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean = false
    override def combine(x: Boolean, y: Boolean): Boolean =
      (x && !y) || (!x && y)
  }

  implicit val monoidForXnorBoolean: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean = true
    override def combine(x: Boolean, y: Boolean): Boolean =
      (!x || y) && (x || !y)
  }

  // All set for Monoids
  implicit def monoidForSet[A]: Monoid[Set[A]] =
    new Monoid[Set[A]] {
      override def empty: Set[A] = Set.empty[A]
      override def combine(x: Set[A], y: Set[A]): Set[A] = x union y
    }

  val intSetMonoid = Monoid[Set[Int]](monoidForSet)
  println(intSetMonoid.combine(Set(1, 2), Set(2, 3)))

  implicit def semigroupForSet[A]: Semigroup[Set[A]] =
    (x: Set[A], y: Set[A]) => x intersect y

  implicit def monoidSymDiff[A]: Monoid[Set[A]] =
    new Monoid[Set[A]] {
      override def empty: Set[A] = Set.empty
      override def combine(x: Set[A], y: Set[A]): Set[A] =
        (x diff y) union (y diff x)
    }

  // Adding all the things
  implicit val monoidOrder: Monoid[Order] =
    new Monoid[Order] {
      override def empty: Order = Order(0, 0)
      override def combine(x: Order, y: Order): Order =
        Order((x.totalCost |+| y.totalCost), (x.quantity |+| y.quantity))
    }

  def add[A](items: List[A])(implicit m: Monoid[A]): A =
    items.foldLeft(m.empty)(_ |+| _)

  println(add(List(Order(1.0, 2.0), Order(3.0, 1.0))))

}
