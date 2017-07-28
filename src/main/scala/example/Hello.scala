package example

import org.json4s._
import org.json4s.native.Serialization

case class Person(name: String, age: Int)

object Hello extends Greeting with App {
  implicit val formats = Serialization.formats(NoTypeHints)

  println(greeting)
  println(Foo.bar(5))

  println(Serialization.read[Person]("""{"name":"bob","age":12}"""))
  println(Serialization.write(Person("bob", 12)))

}

object Foo {
  def bar(n: Int): Int = n + 2

  def myMap[A](f: A => A, coll: List[A]): List[A] = coll match {
    case Nil => List()
    case head :: tail => f(head) :: foo(f, tail)
  }
}

trait Greeting {
  lazy val greeting: String = "hello"
}
