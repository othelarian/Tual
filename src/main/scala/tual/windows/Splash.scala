package tual.windows

import scalafx.Includes._
import scalafx.application.Platform
import scalafx.scene.Scene
import scalafx.scene.input.KeyCode.Escape
import scalafx.stage.{Stage, StageStyle}
import scalafxml.core.{FXMLView, NoDependencyResolver}

object Splash {

  private var splash_stage: Option[Stage] = None

  def getStage(): Option[Stage] = splash_stage

  def show(stage: Stage) {
    if (splash_stage == None) {
      splash_stage = Some(stage)
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
