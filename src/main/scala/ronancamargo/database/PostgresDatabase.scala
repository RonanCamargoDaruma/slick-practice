package ronancamargo.database

import com.typesafe.config.ConfigFactory
import slick.jdbc.PostgresProfile.api._

import scala.jdk.CollectionConverters._

object PostgresDatabase {
  val database = Database.forConfig(
    "database",
    ConfigFactory.parseMap(
      Map(
        "database.connectionPool"          -> "HikariCP",
        "database.dataSourceClass"         -> "org.postgresql.ds.PGSimpleDataSource",
        "database.numThreads"              -> "10",
        "database.properties.serverName"   -> "localhost",
        "database.properties.portNumber"   -> "15432",
        "database.properties.databaseName" -> "postgres",
        "database.properties.user"         -> "postgres",
        "database.properties.password"     -> "postgres"
      ).asJava
    )
  )

}
