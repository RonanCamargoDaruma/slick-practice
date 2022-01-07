package ronancamargo

import ronancamargo.database.PostgresDatabase
import slick.jdbc.PostgresProfile.api._
import slick.lifted.TableQuery

import scala.concurrent.Future

object Queries {
  val people                                     = TableQuery[PersonTable]
  val personId1: Query[PersonTable, Person, Seq] = people.filter(x => x.id === 1)
  //select id, name from person where id = 1

  val dbio   = personId1.result
  val delete = personId1.delete

  val future: Future[Seq[Person]] = PostgresDatabase.database.run(dbio)

  PostgresDatabase.database.run(dbio)
  PostgresDatabase.database.run(delete)

}
