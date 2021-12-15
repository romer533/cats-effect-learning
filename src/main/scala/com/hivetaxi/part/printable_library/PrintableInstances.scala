package com.hivetaxi.part.printable_library

import com.hivetaxi.part.printable_library.Printable.format

object PrintableInstances {
  implicit val toPrintableInt: Printable[Int] = (value: Int) => value.toString
  implicit val toPrintableString: Printable[String] = (value: String) => value
  implicit val toPrintableCat: Printable[Cat] = (value: Cat) => {
    val name = format(value.name)
    val age = format(value.age)
    val color = format(value.color)
    s"$name, is a $age year-old $color cat."
  }
}
