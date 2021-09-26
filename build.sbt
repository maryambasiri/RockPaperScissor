name := """RockPaperScissor"""
organization := ".com"

version := "1.0-SNAPSHOT"

lazy val root = project in file(".")

scalaVersion := "2.13.6"

libraryDependencies ++= Seq (
  "dev.zio" %% "zio" % "1.0.9",
   "org.scalatest" %% "scalatest" % "3.2.9" % "test"
)
