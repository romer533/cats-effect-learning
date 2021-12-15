package com.hivetaxi.part.printable_library

import com.hivetaxi.part.printable_library.PrintableInstances.toPrintableCat
import com.hivetaxi.part.printable_library.PrintableSyntax.PrintableOps

object Main extends App {
  val cat = Cat("Bars", 7, "Black")
  cat.print
}
