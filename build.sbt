name := "conway"

version := "1.0"

scalaVersion := "2.11.1"

ideaExcludeFolders ++= Seq( ".idea", ".idea_modules" )

// Test dependencies
libraryDependencies ++= Seq(
    "org.scalatest" % "scalatest_2.11" % "2.1.7" % "test"
)
