package ronancamargo

import ronancamargo.entities.Person
import slick.jdbc.PostgresProfile.api._

import java.time.LocalDateTime

class PersonTable(tag: Tag) extends Table[Person](tag, "person") {

  def identification = column[Int]("identification")
  def id             = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def firstName      = column[String]("first_name")
  def lastName       = column[String]("last_name")
  def age            = column[Int]("age")
  def address        = column[String]("address")
  def city           = column[String]("city")
  def country        = column[Int]("country")
  def creation       = column[LocalDateTime]("creation_datetime")

  override def * =
    (id, firstName, lastName, identification, age, address, city, country, creation) <> (Person.tupled, Person.unapply)
}

object PersonTable {
  val table = TableQuery[PersonTable]
}
