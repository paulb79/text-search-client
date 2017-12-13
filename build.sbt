lazy val root = (project in file("."))
  .settings (
    name          := "Search Loader",
    organization  := "net.pb",
    scalaVersion  := "2.12.4",
    version       := "latest"
  )

resolvers += Resolver.url("bintray-sbt-plugins", url("https://dl.bintray.com/sbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)

libraryDependencies ++= Seq(
  "org.elasticsearch" % "elasticsearch" % "2.3.2",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)