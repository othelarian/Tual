package tual.windows

import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.application.Platform
import scalafx.scene.Scene
import scalafx.scene.input.KeyCode.Escape
import scalafx.stage.{Stage, StageStyle}
import scalafxml.core.{FXMLView, NoDependencyResolver}

object Splash {

  //
  // TODO : try to keep the stage alive, maybe close method just hide it
  //
  private var used = false
  private var splash_stage: Option[Stage] = None

  def getStage(): Option[Stage] = splash_stage

  def show() {
    if (splash_stage == None) {
      val stage = new PrimaryStage 
      splash_stage = Some(stage)
      if (!used) {
        used = true
        stage.title = "Tual - Startup"
        stage.initStyle(StageStyle.Undecorated)
        stage.alwaysOnTop = true
        stage.width = 460
        stage.height = 230
        stage.resizable = false
        val resource = getClass.getResource("/fxml/splash.fxml")
        val root = FXMLView(resource, NoDependencyResolver)
        root.onKeyReleased = keyEvent => {
          keyEvent.code match {
            case Escape => Platform.exit()
            case _ => ()
          }
        }
        stage.scene = new Scene(root) {
          fill = tual.tools.Style.currentBgColor
          stylesheets = tual.tools.Style.currentStyle
        }
      }
      stage.show
    }
    else {
      println("The splash screen is already on")
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
