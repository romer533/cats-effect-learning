package com.hivetaxi.part.second

import cats.Monoid
import cats.kernel.Semigroup

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

}
