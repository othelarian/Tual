package tual.tools

import cats.effect.IO
import cats.implicits._
//import doobie.ConnectionIO
import doobie.implicits._
import doobie.util.transactor.Transactor
import scala.concurrent.ExecutionContext

object FileDB {
  implicit private val cs = IO.contextShift(ExecutionContext.global)

  // SQLITE REQUESTS
  //
  // TODO : list all the tables?
  //
  private val create_test = ""

  // METHODS
  //
  // TODO : define endpoints
  //
  def createFileDB(path: String): Either[Throwable, Int] = {
    //
    // TODO : handle file creation
    //
    println(path)
    //
    val transactor = Transactor.fromDriverManager[IO](
      "org.sqlite.JDBC", "jdbc:sqlite:"++path, "", ""
    )
    //
    //
    // TODO : create the tables
    //
    // TODO : fill the db with some basic datas
    //
    //transactor
    //
    //sql"select 42"
    sql"select * from sqlite_master"
      .query[Int].unique
      .attempt
      .transact(transactor)
      .unsafeRunSync
    //
  }
}
