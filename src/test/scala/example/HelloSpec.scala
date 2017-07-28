package example

import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    Hello.greeting shouldEqual "hello"
    Hello.main(Array())
  }

  "The Foo object" should "add two" in {
    Foo.bar(5) shouldEqual 7
    Foo.bar(2) shouldEqual 4
  }
}
