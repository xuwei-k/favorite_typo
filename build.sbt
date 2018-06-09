name := "favorite_typo"

version := "0.1-SNAPSHOT"

organization := "com.github.xuwei-k"

licenses += ("MIT License", url("http://www.opensource.org/licenses/mit-license.php"))

resolvers += Opts.resolver.sonatypeReleases

resolvers += "twitter4j" at "http://twitter4j.org/maven2"

scalaVersion := "2.12.6"

val twitter4jVersion = "4.0.3"

libraryDependencies ++= (
  ("org.twitter4j" % "twitter4j-stream" % twitter4jVersion) ::
  ("org.scala-lang" % "scala-compiler" % scalaVersion.value) ::
  Nil
)

val unusedWarnings = (
  "-Ywarn-unused" ::
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
  "-deprecation" ::
  Nil
) ::: unusedWarnings

Seq(Compile, Test).flatMap(c =>
  scalacOptions in (c, console) ~= {_.filterNot(unusedWarnings.toSet)}
)

resourceGenerators in Compile += task(
  Seq(baseDirectory.value / "build.sbt")
)

sourcesInBase := false

assemblyJarName in assembly := {
  val df = new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm")
  s"${name.value}-${df.format(new java.util.Date)}-twitter4j-${twitter4jVersion}.jar"
}
