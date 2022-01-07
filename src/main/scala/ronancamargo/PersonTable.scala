package ronancamargo

import slick.jdbc.PostgresProfile.api._

case class Person(id: Int, firstName: String)

class PersonTable(tag: Tag) extends Table[Person](tag, "person") {

  def id    = column[Int]("id")
  def name2 = column[String]("name")

  override def * = (id, name2) <> (Person.tupled, Person.unapply)
}
