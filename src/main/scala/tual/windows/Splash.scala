package tual.windows

import scalafx.Includes._
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.stage.Stage
import scalafx.event.ActionEvent
import scalafxml.core.{FXMLView, NoDependencyResolver}

object Splash {

  private var splash_stage: Option[Stage] = None

  def show(stage: Stage) {
    if (splash_stage == None) {
      splash_stage = Some(stage)
      stage.title = "Tual - Startup"
      //stage.initStyle(StageStyle.Undecorated)
      stage.alwaysOnTop = true
      //
      // TODO : change the size of the stage
      //
      stage.width = 600
      stage.height = 400
      //
      // TODO : center the splash
      //
      // TODO : add ESC to the splash
      //
      stage.resizable = false
      val resource = getClass.getResource("/fxml/splash.fxml")
      val root = FXMLView(resource, NoDependencyResolver)
      stage.scene = new Scene(root) {
        fill = Color.White
        stylesheets = tual.Tual.stylesheet
      }
    }
    else {
      println("The splash screen is already on")
    }
  }

  def testcall(event: ActionEvent) {
    //
    // TODO : remove this test
    //
    println("test call")
    //
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

  /*
  private def left_side = (stage: Stage) => {
    //
    new VBox {
      children = Seq(
        new Text {
          style = "-fx-font: normal 80pt sans-serif"
        },
        new Button {
          text = "New"
          styleClass += "classic_btn"
          onAction = _ => {
            //
            stage.close()
            //
            tual.Tual.open()
            //
          }
  */
