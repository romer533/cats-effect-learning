package com.hivetaxi

import cats.Show
import cats.implicits.toShow
import cats.instances.string._
import cats.syntax.semigroup._
import com.hivetaxi.part.first.PrintableInstances._
import com.hivetaxi.part.first.PrintableSyntax.PrintableOps
import com.hivetaxi.part.first.{Cat, Printable}

object Main extends App {

  println("Hello " |+| "Cats!\n")

  // Printable library
  Printable.print(123)
  Printable.print("String 123.")

  // Using the library
  val cat = Cat("Simba", 7, "Gray")
  Printable.print(cat)

  // Better Syntax
  cat.print

  // Cat Show
  implicit val showFromCat: Show[Cat] = Show.show[Cat] { value =>
    s"${value.name} is a ${value.age} year-old ${value.color} cat."
  }
  println(cat.show)

}
