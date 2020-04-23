package tual.tools

import java.util.prefs.Preferences

import scalafx.scene.control.{Alert, ButtonType}
import scalafx.scene.control.Alert.AlertType
import scalafx.application.Platform

sealed trait PrefsStatus
case class PrefsOk(val list: Seq[String]) extends PrefsStatus
case class PrefsNo() extends PrefsStatus

object Prefs {
  //
  // TODO : using java.utils.Prefs
  //

  private var noPrefs = false

  def checkPrefs() {
    //
    //
    // TODO : check if there is already a prefs file
    //
    // TODO : if there is a prefs file, try to read it
    //
    // TODO : if there is no prefs file, try to write it
    //
    // TODO : if something wrong happen, Left with why
    //
    // askNoPrefs("Error?")
    //
    // TODO : if it's all good, right with number of previously opened stories
    //
    //
  }

  def getPrefs(): PrefsStatus = {
    if (noPrefs) PrefsNo()
    else {
      //
      // TODO : get the number of previously opened stories
      //
      //
      // TODO : limit previously opened stories title to 37 chars
      //
      // TODO : update the Seq included type, String isn't enough
      //
      //PrefsOk(Seq())
      /*PrefsOk(Seq(
        "Test 678 012 456 890 234 678 012",
        "Value of Castle",
        "Veni Vidi Vici, cesar rocks",
        //"I'm the best story ever",
        "I'm here!"))
        */
      PrefsNo()
      //
    }
  }

  def showPrefs() {
    //
    // TODO : check, like with Splash, if the window is already open, to avoid 2 settings windows opened simultaneously
    //
    // TODO : lock the creation of the window if NoPrefs is active
    //
    println("showPrefs -> not implemented yet")
    //
  }

  def pushStory() {
    //
    // TODO : handle the push in the previously opened stories historic of a new story
    //
    println("pushStory -> Not implemented yet")
    //
  }

  private def askNoPrefs(e: String) {
    val NoPrefContinue = new ButtonType("Continue without prefs")
    val NoPrefQuit = new ButtonType("Quit")
    val alert = new Alert(AlertType.Confirmation) {
      title = "Tual - Issue with preferences"
      headerText = "We met the issue below when trying to deal with preferences"
      contentText = e
      buttonTypes = Seq(NoPrefContinue, NoPrefQuit)
    }
    alert.showAndWait() match {
      case Some(NoPrefContinue) => noPrefs = true
      case Some(NoPrefQuit) => Platform.exit
      case _ => ()
    }
  }
}
