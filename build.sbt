name := "Scala1"

version := "0.1"

scalaVersion := "2.12.5"

scalacOptions += "-Ypartial-unification"

libraryDependencies ++= Seq(
  "org.tpolecat" %% "doobie-core" % "0.5.1",
  "com.microsoft.sqlserver" % "mssql-jdbc" % "6.4.0.jre8"
)