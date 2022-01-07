package ronancamargo

import slick.jdbc.PostgresProfile.api._

import java.time.LocalDateTime

case class Person(
    id: Int,
    firstName: String,
    lastName: String,
    identification: Int,
    age: Int,
    address: String,
    city: String,
    country: Int,
    creationDateTime: LocalDateTime
)

class PersonTable(tag: Tag) extends Table[Person](tag, "person") {

  def id    = column[Int]("id")
  def name2 = column[String]("name")

  override def * = (id, name2) <> (Person.tupled, Person.unapply)
}
