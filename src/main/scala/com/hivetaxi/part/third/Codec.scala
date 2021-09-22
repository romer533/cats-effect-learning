package com.hivetaxi.part.third

trait Codec[A] { self =>
  def encode(v: A): String
  def decode(v: String): A
  def imap[B](d: A => B, e: B => A): Codec[B] = new Codec[B] {
    override def encode(v: B): String = self.encode(e(v))
    override def decode(v: String): B = d(self.decode(v))
  }
}
