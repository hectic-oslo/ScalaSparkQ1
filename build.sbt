// Project version
ThisBuild / version := "0.1.0-SNAPSHOT"
fork := true
// Remove the line below
// javaOptions += "-Djava.security.manager=allow"

// Scala version
ThisBuild / scalaVersion := "2.12.18"

// Project name and dependencies
lazy val root = (project in file("."))
  .settings(
    name := "ScalaSparkAssignment",
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-sql" % "3.4.1", // Spark SQL for DataFrame and Dataset operations
      "org.apache.spark" %% "spark-core" % "3.4.1" // Spark Core for the main Spark API
    )
  )
