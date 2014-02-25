name := "conway"

version := "1.0"

scalaVersion := "2.10.3"

ideaExcludeFolders ++= Seq( ".idea", ".idea_modules" )

// Test dependencies
libraryDependencies ++= Seq(
    "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
)
