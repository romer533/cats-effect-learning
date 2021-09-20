package com.hivetaxi.part.first

import cats.implicits.{catsSyntaxEq, catsSyntaxSemigroup, toShow}
import cats.instances.int._
import cats.instances.string._
import cats.{Eq, Show}
import com.hivetaxi.part.first.PrintableInstances.{
  printableFromCat,
  printableFromInt,
  printableFromString
}
import com.hivetaxi.part.first.PrintableSyntax.PrintableOps

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

  // Equality, liberty, and felinity
  implicit val eqFromCat: Eq[Cat] = Eq.instance[Cat] { (value1, value2) =>
    value1.name === value2.name && value1.age === value2.age && value1.color === value2.color
  }
  val cat1 = cat
  val cat2 = Cat("Leva", 3, "Black")
  println(cat1 === cat2)
  println(cat1 =!= cat2)

}