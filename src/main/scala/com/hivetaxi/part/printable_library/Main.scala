package com.hivetaxi.part.printable_library

import com.hivetaxi.part.printable_library.PrintableInstances.toPrintableCat

object Main extends App {
  val cat = Cat("Bars", 7, "Black")
  Printable.print(cat)
}
