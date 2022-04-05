ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "openAPI",
    organization := "miguelemos",
    organizationHomepage := Some(url("https://github.com/miguelemosreverte"))
  )

// https://mvnrepository.com/artifact/org.openapi4j/openapi-parser
libraryDependencies += "org.openapi4j" % "openapi-parser" % "1.0.7"
libraryDependencies += "fr.loicknuchel" %% "typedapi" % "0.1.1"

licenses := Seq(
  ("CC0", url("https://creativecommons.org/publicdomain/zero/1.0"))
)
