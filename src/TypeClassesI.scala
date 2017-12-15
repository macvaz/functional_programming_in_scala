// Implement manually each evidence class as an object and use evidence class API
// No common implementation of a unique library

// Type class
// The type class itself is a trait with a single type parameter.
trait HtmlWriter[T] {
  def write(value: T): String
}

// Evidence class
object UserCanWrite extends HtmlWriter[User] {
  override def write(user: User) = user.name
}

// Application domain
case class User(name: String, age: Int)
val user = User("miguel", 34)

UserCanWrite.write(user)

