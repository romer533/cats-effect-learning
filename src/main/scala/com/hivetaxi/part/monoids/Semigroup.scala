package com.hivetaxi.part.monoids

trait Semigroup[A] {
  def combine(x: A, y: A): A
}
