package com.hivetaxi.part.printableLibrary

object PrintableInstances {
  implicit val toPrintableInt: Printable[Int] = (value: Int) => value.toString
  implicit val toPrintableString: Printable[String] = (value: String) => value
}
