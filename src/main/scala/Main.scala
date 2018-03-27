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

  val y = xa.yolo
  import y._

  val age = 21.toByte

  val q = sql"""select name, age from dbo.people where age = $age""".query[(String, Byte)]

  q.check.unsafeRunSync

    val res =
    q.stream
     .quick
     .unsafeRunSync

  println(res)
}