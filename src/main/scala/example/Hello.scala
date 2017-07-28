package example

import scalaj.http._

import org.json4s.NoTypeHints
import org.json4s.stream2JsonInput
import org.json4s.native.Serialization

import scalaj.http._

case class Person(name: String, age: Int)

case class SubredditResult(kind: String)

object Hello extends Greeting with App {
  implicit val formats = Serialization.formats(NoTypeHints)

  println(greeting)
  println(Foo.bar(5))

  println(Serialization.read[Person]("""{"name":"bob","age":12}"""))
  println(Serialization.write(Person("bob", 12)))

  val response = Http("https://www.reddit.com/r/Clojure.json").asString

  val body = Serialization.read[SubredditResult](response.body)

  println(body);


}

object Foo {
  def bar(n: Int): Int = n + 2

  def myMap[A](f: A => A, coll: List[A]): List[A] = coll match {
    case Nil => List()
    case head :: tail => f(head) :: myMap(f, tail)
  }
}

trait Greeting {
  lazy val greeting: String = "hello"
}
