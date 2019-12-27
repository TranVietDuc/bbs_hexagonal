import play.sbt.PlayImport.jdbc
import sbt._

object Dependencies {

  lazy val scalikejdbcVersion = "3.3.2"
  lazy val circeVersion = "0.9.3"
  lazy val json4sJacksonVersion = "3.6.6"
  lazy val mysqlVersion = "8.0.15"
  lazy val akkaVersion = "2.5.22"


  val mysqlConnectorJava = "mysql" % "mysql-connector-java" % mysqlVersion

  val skinnyOrm = "org.skinny-framework" %% "skinny-orm" % "3.0.0"

  val scalikejdbc = "org.scalikejdbc" %% "scalikejdbc" % scalikejdbcVersion
  val scalikejdbcConfig = "org.scalikejdbc" %% "scalikejdbc-config" % scalikejdbcVersion
  val scalikejdbcTest = "org.scalikejdbc" %% "scalikejdbc-test" % scalikejdbcVersion % Test
  val scalikejdbcPlayAdapter = "org.scalikejdbc" %% "scalikejdbc-play-dbapi-adapter" % "2.7.0-scalikejdbc-3.3"
  val logBack = "ch.qos.logback" % "logback-classic" % "1.2.3"

  val playFlyway = "org.flywaydb" %% "flyway-play" % "5.3.2"

  val portDatabaseDependencies = Seq(
    scalikejdbc, scalikejdbcConfig, scalikejdbcTest,
    scalikejdbcPlayAdapter,
    logBack,
    jdbc,
    mysqlConnectorJava,
    skinnyOrm,
    playFlyway
  )

  val playJson4s = "com.github.tototoshi" %% "play-json4s-jackson" % "0.9.0"
  val playJson4sTest = "com.github.tototoshi" %% "play-json4s-test-jackson" % "0.9.0" % "test"
  val json4s = "org.json4s" %% "json4s-ext" % json4sJacksonVersion
  val circeCore = "io.circe" %% "circe-core" % circeVersion
  val circeGeneric = "io.circe" %% "circe-generic" % circeVersion
  val circeParser = "io.circe" %% "circe-parser" % circeVersion
  val playCirce = "com.dripower" %% "play-circe" % "2609.2"

  val scalajHttp = "org.scalaj" %% "scalaj-http" % "2.3.0"

}
