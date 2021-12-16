package com.hivetaxi.part.printable_library

import cats.Eq
import cats.implicits._
import com.hivetaxi.part.printable_library.Show._
import com.hivetaxi.part.printable_library.ShowSyntax.ShowOps

object Main extends App {

  val cat = Cat("Bars", 7, "Black")
  val cat2 = Cat("Simba", 9, "White")

  println(cat.show)

  implicit val catEq: Eq[Cat] =
    Eq.instance { (cat1, cat2) =>
      cat1.name === cat2.name &&
      cat1.age === cat2.age &&
      cat1.color === cat2.color
    }

  val optionCat1 = Option(cat)
  val optionCat2 = Option.empty[Cat]

  println(cat === cat2)
  println(optionCat1 === optionCat2)

}
