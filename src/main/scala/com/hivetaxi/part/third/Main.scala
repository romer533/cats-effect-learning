package com.hivetaxi.part.third

import cats.Functor
import cats.implicits._

object Main extends App {

  // Part 3 for book Scala with Cats
  // Functors

  // Branching out with Functors
  implicit val treeFunctor: Functor[Tree] = new Functor[Tree] {
    def map[A, B](fa: Tree[A])(f: A => B): Tree[B] =
      fa match {
        case Branch(l, r) => Branch(map(l)(f), map(r)(f))
        case Leaf(a)      => Leaf(f(a))
      }
  }
  println(Tree.branch(Tree.leaf(15), Tree.leaf(10)).map(_ * 2))

}
