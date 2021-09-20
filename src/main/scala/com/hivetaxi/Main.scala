package com.hivetaxi

import cats.instances.string._
import cats.syntax.semigroup._
import com.hivetaxi.part.first.PrintableInstances._
import com.hivetaxi.part.first.PrintableSyntax.PrintableOps
import com.hivetaxi.part.first.{Cat, Printable}

object Main extends App {

  println("Hello " |+| "Cats!")

  // Printable library
  Printable.print(123)
  Printable.print("String 123.")

  // Using the library
  val cat = Cat("Simba", 7, "Gray")
  Printable.print(cat)

  // Better Syntax
  cat.print

}
