// Implement manually each evidence class as an implicit value
// Common implementation of a unique library: toHtml

///////////////////////////
// Library code

// Type class
// The type class itself is a trait with a single type parameter.
trait HtmlWriter[T] {
  def write(value: T): String
}

// Evidence class factory
// Given a type parameter and a function that converts a value of type T to string, it creates a HtmlWriter evidence class
object HtmlWriter {
  def apply[T](f: T => String) = new HtmlWriter[T] {
    override def write(value: T) = f(value)
  }
}

// Library API
def toHtml[T](value: T)(implicit writer: HtmlWriter[T]) = writer.write(value)

//////////////////////////////
// Application implementation

// Application domain
case class User(name: String, age: Int)
val user = User("miguel", 34)

implicit val userWriter = HtmlWriter((user: User) => user.name)

toHtml(user)
