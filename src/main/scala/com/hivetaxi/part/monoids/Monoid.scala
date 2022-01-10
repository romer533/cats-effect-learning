package com.hivetaxi.part.monoids

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}

object Monoid {

  def apply[A](implicit monoid: Monoid[A]): Monoid[A] = monoid

  implicit val booleanAndMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean = true
    override def combine(x: Boolean, y: Boolean): Boolean = x && y
  }

  implicit val booleanOrMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean = false
    override def combine(x: Boolean, y: Boolean): Boolean = x || y
  }

  implicit val booleanEitherMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean = false
    override def combine(x: Boolean, y: Boolean): Boolean =
      (x && !y) || (!x && y)
  }

  implicit val booleanXnorMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean = true
    override def combine(x: Boolean, y: Boolean): Boolean =
      (!x || y) && (x || !y)
  }

}
