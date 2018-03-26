import cats._
import cats.data._
import cats.implicits._
import cats.effect._
import doobie._
import doobie.implicits._
import shapeless._

object Main extends App {
  val xa = Transactor.fromDriverManager[IO](
    "com.microsoft.sqlserver.jdbc.SQLServerDriver",
    "jdbc:sqlserver://localhost:1401;database=master;user=sa;password=Vaskir2010"
  )

  case class Person(name: String, age: Int)

  val res =
    sql"select name, age from dbo.people"
      .query[String :: Int :: HNil]
      .to[List]
      .transact(xa)
      .unsafeRunSync

  println(res)
}