name := "twitter-server-example"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "com.twitter" %% "twitter-server" % "18.8.0",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.twitter" %% "twitter-server-logback-classic" % "18.8.0",
  "com.twitter" %% "finagle-stats" % "18.8.0"
)