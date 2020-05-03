package tual.tools

import scalafx.Includes._
import scalafx.stage.{FileChooser, Stage}
import scalafx.stage.FileChooser.ExtensionFilter

sealed abstract class OpeningWay(val uri: Option[String])
case class OpenFromSplash(val selUri: Option[String] = None) extends OpeningWay(selUri)
case class OpenFromMenu(val stage: Stage, val selUri: Option[String] = None) extends OpeningWay(selUri)

class Story {

  private val windowList = List()
  private val dbUri = ""

  //
  //
}

object Story {

  private val storyList = Map()

  //
  // TODO : this is where all the stories are managed
  //

  def openStory(way: OpeningWay) {
    val stage = getStage(way)
    val selectedFile = way.uri match {
      case Some(uri) => uri
      case None => getFile("Open a Story").showOpenDialog(stage)
    }
    selectedFile match {
      case null => ()
      case selectedFile =>
        //
        // TODO : try to open the file
        //
        // TODO : open the story
        //
        //
        // TODO : test to switch between splash to classic
        //
        val c = new tual.windows.Classic()
        c.show()
        //
        //
        tual.windows.Splash.close
        //
        tual.tools.Prefs.pushStory
        //
    }
  }

  def newStory(way: OpeningWay) {
    val stage = getStage(way)
    getFile("New Story").showSaveDialog(stage) match {
      case null => ()
      case selectedFile =>
        //
        println(selectedFile)
        //
        //
        // TODO : create the sqlite file
        //
        // TODO : if it's impossible to write on the selected dir, pop an alert
        //
        // TODO : close the splash and launch the story
        //
        //
        //
        tual.tools.Prefs.pushStory()
        //
        //
    }
  }

  private def getStage(way: OpeningWay): Stage = {
    way match {
      case OpenFromSplash(_) => tual.windows.Splash.getStage.get
      case OpenFromMenu(stage, _) => stage
    }
  }

  private def getFile(title: String): FileChooser = {
    val t = "Tual - "++title
    new FileChooser {
      title = t
      extensionFilters ++= Seq(new ExtensionFilter("Tual file", "*.tual"))
    }
  }
}
