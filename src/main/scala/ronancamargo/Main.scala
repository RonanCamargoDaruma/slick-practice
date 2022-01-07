package ronancamargo

import ronancamargo.database.PostgresDatabase
import ronancamargo.entities.Person
import slick.jdbc.PostgresProfile.api._

import java.time.LocalDateTime
import scala.concurrent.ExecutionContext

object Main extends App {

  //==============E1================
  val table = PersonTable.table

  val person = Person(
    id = 1,
    firstName = "asd",
    lastName = "asd",
    identification = 1,
    age = 23,
    address = "asd",
    city = "asd",
    country = 1,
    creationDateTime = LocalDateTime.now()
  )

  val insert = table += person

  val select    = table.filter(p => p.firstName === "asd" && p.id === 4).result.headOption
  val selectOne = table.filter(p => p.firstName === "asd").take(10).result.headOption

  val selectId2 = table.filter(p => p.id === 2)

  val update = selectId2.map(p => (p.age, p.country)).update((100, 2))

  val deleteId2       = table.filter(p => p.id === 2).delete
  val deleteId2Reused = selectId2.delete

  val projection = for {
    t <- table if t.firstName === "asd"
    s <- selectId2
    projection = (t.id, s.id)
  } yield projection

  // q1 and q2 are equivalent
  val q1 = for {
    p <- table if p.firstName === "asd"
  } yield (p.age, p.country)

  val q2 = table.filter(p => p.firstName === "asd").map(p => (p.age, p.country))

  //==============E2================
  //Find a given row then update its city or create it if not exists
  implicit val executionContext: ExecutionContext = ExecutionContext.global

  val personInCordoba = person.copy(city = "Cordoba")

  val query: Query[PersonTable, Person, Seq] = table.filter(p => p.id === 4)
  val findPerson: DBIO[Option[Person]]       = query.result.headOption
  val updatePerson: DBIO[Int]                = query.map(p => p.city).update(personInCordoba.city)
  val insertPerson: DBIO[Int]                = table += personInCordoba

  val dbio = for {
    maybePerson <- findPerson
    rows        <- upsert(maybePerson)
  } yield rows

  Util.awaitAndPrintResult(PostgresDatabase.database.run(dbio))

  //==============
  def upsert(person: Option[Person]): DBIO[Int] =
    person match {
      case Some(_) => updatePerson
      case None    => insertPerson
    }
}
