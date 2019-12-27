import sbt.Keys.resolvers
import sbt._
import Dependencies._

name := "untitled"
 
version := "1.0" 

//unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

lazy val commonSettings = Seq(
  resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases",

  resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/",

  scalaVersion := "2.12.2",

  libraryDependencies ++= Seq(jdbc, ehcache, ws, specs2 % Test, guice)
)

lazy val subProject = Seq(
  scalaSource in Compile := baseDirectory.value / "src" / "main" / "scala",
  scalaSource in Test := baseDirectory.value / "src" / "test" / "scala",
  resourceDirectory in Compile := baseDirectory.value / "src" / "main" / "resources",
  resourceDirectory in Test := baseDirectory.value / "src" / "test" / "resources"
)
lazy val root = (project in file ("."))
  .aggregate(utility, domain, application, port)
  .dependsOn(utility, domain, application  % "compile->compile", port)
  .settings(commonSettings)
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)

// Port
lazy val port = (project in file("bbs/port"))
  .aggregate(portHttp,portDatabase)
  .dependsOn(portHttp, portDatabase)
  .settings(commonSettings)
  .settings(subProject)

lazy val portHttp = (project in file("bbs/port/primary/http"))
  .dependsOn(utility, application  % "compile->compile")
  .settings(commonSettings)
  .settings(subProject)
  .enablePlugins(PlayScala)
  .enablePlugins(FlywayPlugin)
  .settings(libraryDependencies ++= Seq(playJson4s, playJson4sTest, json4s))

lazy val portDatabase = (project in file("bbs/port/secondary/database"))
  .dependsOn(utility, application  % "compile->compile")
  .settings(commonSettings)
  .settings(subProject)
  .settings(libraryDependencies ++= portDatabaseDependencies)
  .enablePlugins(FlywayPlugin)
  .settings(
    flywayLocations := Seq("filesystem:bbs/port/secondary/database/src/main/resources/db.migration.default")
  )

// Domain
lazy val domain = (project in file("bbs/domain"))
  .aggregate(bbsDomain)
  .dependsOn(bbsDomain)
  .settings(commonSettings)
  .settings(subProject)

lazy val bbsDomain = (project in file("bbs/domain/bbs"))
  .dependsOn(utility)
  .settings(commonSettings)
  .settings(subProject)

// Application
lazy val application = (project in file("bbs/application"))
  .dependsOn(utility, domain)
  .settings(commonSettings)
  .settings(subProject)
  .settings(
    libraryDependencies ++= Seq("com.typesafe.play" %% "anorm" % "2.5.3")
  )
  .settings(libraryDependencies ++= Seq(circeCore, circeGeneric, circeParser, playCirce))

lazy val utility = Project(
  id = "bbs-utility",
  base = file("bbs/utility")
).settings(commonSettings)
  .settings(subProject)
  .settings(libraryDependencies ++= Seq("io.sentry" % "sentry" % "1.7.16", "io.sentry" % "sentry-logback" % "1.1.0"))
  .settings(libraryDependencies ++= Seq(playJson4s, playJson4sTest, json4s))




      