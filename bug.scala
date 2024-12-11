```scala
class MyClass[T](val value: T) {
  def myMethod(x: T): T = {
    value match {
      case _: String => x.asInstanceOf[String].toUpperCase.asInstanceOf[T]
      case _ => x
    }
  }
}

object Main extends App {
  val myString = new MyClass("hello")
  val upperString = myString.myMethod("world")
  println(upperString) // Output: WORLD

  val myInt = new MyClass(10)
  val newInt = myInt.myMethod(20)
  println(newInt) // Output: 20
}
```