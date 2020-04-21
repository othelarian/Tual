package tual.tools

import scalafx.scene.control.{Alert, ButtonType}
import scalafx.scene.control.Alert.AlertType
import scalafx.application.Platform

sealed trait PrefsStatus
case class PrefsOk(val nb: Int) extends PrefsStatus
case class PrefsNo() extends PrefsStatus
//case class PrefsError(val error: String) extends PrefsStatus

object Prefs {
  //
  // TODO : using java.utils.Prefs
  //

  private var noPrefs = false

  def checkPrefs(): PrefsStatus = {
    if (noPrefs) PrefsNo()
    else {
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
      // TODO : if it's all good, right with number of previously opened stories
      //
      //
      // TODO : simulation that something bad happened
      //
      //askNoPrefs("issue ???")
      PrefsNo()
      //
    }
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
      case Some(NoPrefContinue) => goWithoutPrefs
      case Some(NoPrefQuit) => Platform.exit
      case _ => ()
    }
  }

  def goWithoutPrefs() { noPrefs = true }
}
