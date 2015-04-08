name := "favorite_typo"

version := "0.1-SNAPSHOT"

organization := "com.github.xuwei-k"

licenses += ("MIT License", url("http://www.opensource.org/licenses/mit-license.php"))

resolvers += Opts.resolver.sonatypeReleases

resolvers += "twitter4j" at "http://twitter4j.org/maven2"

scalaVersion := "2.11.6"

val twitter4jVersion = "4.0.2"

libraryDependencies ++= (
  ("org.twitter4j" % "twitter4j-stream" % twitter4jVersion) ::
  ("org.scala-lang" % "scala-compiler" % scalaVersion.value) ::
  Nil
)

scalacOptions ++= (
  "-deprecation" ::
  "-unchecked" ::
  "-Xlint" ::
  "-language:postfixOps" ::
  "-language:existentials" ::
  "-language:higherKinds" ::
  "-language:implicitConversions" ::
  "-Ywarn-unused" ::
  "-Ywarn-unused-import" ::
  Nil
)

resourceGenerators in Compile += task(
  Seq(baseDirectory.value / "build.sbt")
)

sourcesInBase := false

assemblySettings

AssemblyKeys.jarName in AssemblyKeys.assembly := {
  val df = new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm")
  s"${name.value}-${df.format(new java.util.Date)}-twitter4j-${twitter4jVersion}.jar"
}
