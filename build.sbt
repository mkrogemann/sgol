name := "conway"

version := "1.0"

scalaVersion := "2.11.1"

// Test dependencies
libraryDependencies ++= Seq(
    "org.scalatest" % "scalatest_2.11" % "2.1.7" % "test",
    "org.pegdown" % "pegdown" % "1.4.2" % "test"
)

testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")
