scalaVersion := "2.13.1"

name := "Tual"
organization := "play.othy.scala"
version := "1.0"

scalacOptions += "-Ymacro-annotations"

//libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"

// sqlite Deps ########################
libraryDependencies ++= Seq(
  "org.xerial"   % "sqlite-jdbc"    % "3.23.1",
  "org.tpolecat" %% "doobie-core"   % "0.8.8",
  "org.tpolecat" %% "doobie-hikari" % "0.8.8",
  "org.tpolecat" %% "doobie-specs2" % "0.8.8"
)

// ScalaFX Deps #######################
//libraryDependencies += "org.scalafx" %% "scalafx-extras" % "0.3.3"
libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafx"             % "12.0.2-R18",
  "org.scalafx" %% "scalafxml-core-sfx8" % "0.5"
)

lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux")   => "linux"
  case n if n.startsWith("Mac")     => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}

lazy val javaFXModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
libraryDependencies ++= javaFXModules.map( m =>
  "org.openjfx" % s"javafx-$m" % "12.0.2" classifier osName
)