package com.hivetaxi.part.printable_library

object ShowSyntax {
  implicit class ShowOps[A](value: A) {
    def show(implicit show: Show[A]): String = show.show(value)
  }
}
