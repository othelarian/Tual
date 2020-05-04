package tual.tools

import scalafx.Includes._
import scalafx.stage.{FileChooser, Stage}
import scalafx.stage.FileChooser.ExtensionFilter

import tual.windows.Splash
import scala.util.Try

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
        Splash.close
        //
        Prefs.pushStory
        //
    }
  }

  def newStory(way: OpeningWay) {
    val stage = getStage(way)
    val chooser = getFile("New Story")
    chooser.initialFileName = "new_story.tual"
    chooser.showSaveDialog(stage) match {
      case null => ()
      case selectedFile =>
        //
        // TODO : if hte file exists, delete it
        //
        val prep = selectedFile.isFile match {
          case true =>
            //
            Try(selectedFile.delete).isSuccess
            //
            // TODO : test is the delete failed
            //
            false
            //
          case false => true
        }
        if (prep) {
          //
          // TODO : continue
          //
        } else {
          //
          // TODO : failed to delete, catch this
          //
          stage.alert
          //
          //
        }
        //
        //
        // TODO : create the sqlite file
        //
        val res = FileDB.createFileDB(selectedFile.toString)
        res match {
          case Left(e) =>
            //
            // TODO : everything goes wrong
            //
            println(e)
            //
            // TODO : can't call Splash, we don't konw if this come from splash or not
            //Splash.switchToSelector
            //
          case Right(v) =>
            //
            // TODO : everything goes fine
            //
            println(v)
            //
        }
        //
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
      case OpenFromSplash(_) =>
        Splash.switchToWaitor
        Splash.stage
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
