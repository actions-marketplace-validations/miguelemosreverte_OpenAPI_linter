ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "openAPI"
  )

// https://mvnrepository.com/artifact/org.openapi4j/openapi-parser
libraryDependencies += "org.openapi4j" % "openapi-parser" % "1.0.7"
libraryDependencies += "fr.loicknuchel" %% "typedapi" % "0.1.1"

organization := "customer"
organizationHomepage := Some(url("https://akkaserverless.com"))
licenses := Seq(
  ("CC0", url("https://creativecommons.org/publicdomain/zero/1.0"))
)
