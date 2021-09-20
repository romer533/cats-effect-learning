package com.hivetaxi.part.first

trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances {
  implicit val printableFromString: Printable[String] = (value: String) => value
  implicit val printableFromInt: Printable[Int] = (value: Int) => value.toString
  implicit val printableFromCat: Printable[Cat] = (value: Cat) => s"${value.name} is a ${value.age} year-old ${value.color} cat."
}

object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String = p.format(value)
  def print[A](value: A)(implicit p: Printable[A]): Unit =
    println(format(value))
}
