name := "assignment"
version := "1.0"
scalaVersion := "2.12.12"

lazy val common = project.in(file("common"))
  .settings(libraryDependencies ++= Seq("io.github.embeddedkafka" %% "embedded-kafka" % "3.0.0",
    "org.json4s" %% "json4s-native" % "4.0.2",
    "org.scalactic" %% "scalactic" % "3.3.0-SNAP3",
    "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test,
    "org.mockito" %% "mockito-scala" % "1.16.46" % Test
  )
  )

lazy val actor = project.in(file("actor"))
  .settings(libraryDependencies ++= Seq("com.typesafe.akka" %% "akka-actor-typed" % "2.6.17",
    "com.typesafe.akka" %% "akka-stream" % "2.6.17",
    "com.typesafe.akka" %% "akka-persistence-typed" % "2.6.17",
    "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.6.17" % Test,
    "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test
  )
  ).dependsOn(common)

lazy val root = project.in(file(".")).aggregate(common,actor)

