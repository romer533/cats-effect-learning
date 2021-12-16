package com.hivetaxi.part.printable_library

import cats.implicits._

trait Show[A] {
  def show(value: A): String
}

object Show {

  def apply[A](implicit instance: Show[A]): Show[A] = instance

  implicit val catShow: Show[Cat] = (cat: Cat) => {
    val name = cat.name.show
    val age = cat.age.show
    val color = cat.color.show
    s"$name, is a $age year-old $color cat."
  }
}
