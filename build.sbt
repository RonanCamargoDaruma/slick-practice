scalaVersion := "2.13.7"
organization := "ronancamargo"
name         := "slick-practice"

val slickVersion = "3.3.3"
val catsVersion              = "2.7.0"
val catsEffectVersion        = "3.3.0"
val mouseVersion             = "1.0.8"

libraryDependencies ++= databaseDependencies
libraryDependencies ++= catsDependencies

lazy val databaseDependencies = Seq(
  "com.typesafe.slick" %% "slick"          % slickVersion,
  "com.typesafe.slick" %% "slick-hikaricp" % slickVersion,
  "org.postgresql"      % "postgresql"     % "42.3.1"
)

lazy val catsDependencies     = Seq(
  "org.typelevel" %% "cats-core"   % catsVersion,
  "org.typelevel" %% "cats-effect" % catsEffectVersion,
  "org.typelevel" %% "mouse"       % mouseVersion
)
