name := """RockPaperScissor"""
organization := ".com"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.6"

libraryDependencies += guice
libraryDependencies ++= Seq (
  "dev.zio" %% "zio" % "1.0.9",
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
   "org.scalatest" %% "scalatest" % "3.2.9" % "test"
)


// Adds additional packages into Twirl
//TwirlKeys.templateImports += ".com.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += ".com.binders._"
