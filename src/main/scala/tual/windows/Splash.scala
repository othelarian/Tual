package tual.windows

import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.application.Platform
import scalafx.scene.Scene
import scalafx.scene.input.KeyCode.Escape
import scalafx.stage.StageStyle
import scalafxml.core.{FXMLLoader, NoDependencyResolver}
import javafx.{scene => jfxs}

import tual.controllers.SplashControlInterface

object Splash {

  val stage = new PrimaryStage {
    title = "Tual - Startup"
    alwaysOnTop = true
    width = 460
    height = 230
    resizable = false
  }
  stage.initStyle(StageStyle.Undecorated)

  private val resource = getClass.getResource("/fxml/splash.fxml")
  private val loader = new FXMLLoader(resource, NoDependencyResolver)
  loader.load
  private val root = loader.getRoot[jfxs.Parent]
  private val controller = loader.getController[SplashControlInterface]
  private val scene = new Scene(root) {
    fill = tual.tools.Style.currentBgColor
    stylesheets = tual.tools.Style.currentStyle
  }
  scene.onKeyReleased = keyEvent => {
    keyEvent.code match {
      case Escape => Platform.exit()
      //
      // TODO : handle test
      //
      case scalafx.scene.input.KeyCode.A =>
        //
        controller.activeWaitor
        //
        println("test from splash")
        //
      case scalafx.scene.input.KeyCode.Z =>
        //
        tual.tools.Story.openStory(
          tual.tools.OpenFromSplash(Some("test"))
        )
        //
        //
      //
      case _ => ()
    }
  }
  stage.scene = scene

  def show = {
    controller.activeSelector
    stage.show
  }
  def switchToSelector = controller.activeSelector
  def switchToWaitor = controller.activeWaitor
  def close = stage.close
}
