```scala
trait MyTypeClass[T] {
  def transform(x: T): T
}

object MyTypeClassInstances {
  implicit val stringInstance = new MyTypeClass[String] {
    override def transform(x: String): String = x.toUpperCase
  }

  implicit val intInstance = new MyTypeClass[Int] {
    override def transform(x: Int): Int = x
  }
}

class MyClass[T](val value: T)(implicit tc: MyTypeClass[T]) {
  def myMethod(x: T): T = tc.transform(x)
}

object Main extends App {
  implicit val stringInstance = MyTypeClassInstances.stringInstance
  implicit val intInstance = MyTypeClassInstances.intInstance

  val myString = new MyClass("hello")
  val upperString = myString.myMethod("world")
  println(upperString) // Output: WORLD

  val myInt = new MyClass(10)
  val newInt = myInt.myMethod(20)
  println(newInt) // Output: 20
}
```