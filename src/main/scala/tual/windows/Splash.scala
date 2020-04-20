package tual.windows

import scalafx.Includes._
import scalafx.application.Platform
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.input.KeyCode.Escape
import scalafx.scene.control.{Alert, ButtonType}
import scalafx.scene.control.Alert.AlertType
import scalafx.stage.{Popup, Stage, StageStyle}
import scalafxml.core.{FXMLView, NoDependencyResolver}

sealed abstract class PrefResult

case class PrefQuit() extends PrefResult
case class PrefContinueWithout() extends PrefResult
case class PrefWithValue(value: Int) extends PrefResult

object Splash {

  private var splash_stage: Option[Stage] = None

  def show(stage: Stage) {
    if (splash_stage == None) {
      val lastOpenNb = getPrefs match {
        case a: PrefQuit =>
          Platform.exit()
          None
        case b: PrefContinueWithout => None
        case v: PrefWithValue => Some(v.value)
      }
      splash_stage = Some(stage)
      stage.title = "Tual - Startup"
      stage.initStyle(StageStyle.Undecorated)
      stage.alwaysOnTop = true
      //
      // TODO : change the size of the stage
      //
      stage.width = 600
      stage.height = 400
      //
      // TODO : center the splash
      //
      stage.resizable = false
      val resource = getClass.getResource("/fxml/splash.fxml")
      //
      // TODO : change the dependency resolver to integrate prefs result
      //
      val root = FXMLView(resource, NoDependencyResolver)
      //
      root.onKeyReleased = keyEvent => {
        keyEvent.code match {
          case Escape => Platform.exit()
          case _ => ()
        }
      }
      stage.scene = new Scene(root) {
        fill = Color.White
        stylesheets = tual.Tual.stylesheet
      }
    }
    else {
      println("The splash screen is already on")
    }
  }

  def getPrefs(): PrefResult = {
    tual.tools.Prefs.checkPrefs() match {
      case Left(e) =>
        val NoPrefContinue = new ButtonType("Continue without prefs")
        val NoPrefQuit = new ButtonType("Quit")
        val alert = new Alert(AlertType.Confirmation) {
          title = "Tual - Issue with preferences"
          headerText = "We met the issue below when trying to deal with preferences"
          contentText = e
          buttonTypes = Seq(NoPrefContinue, NoPrefQuit)
        }
        alert.showAndWait() match {
          case Some(NoPrefContinue) =>
            tual.tools.Prefs.goWithoutPrefs()
            PrefContinueWithout()
          case Some(NoPrefQuit) => PrefQuit()
          case _ => PrefQuit()
        }
      case Right(v) => PrefWithValue(v)
    }
  }

  def close() {
    splash_stage match {
      case Some(stage) => {
        stage.close()
        splash_stage = None
      }
      case None => ()
    }
  }
}
