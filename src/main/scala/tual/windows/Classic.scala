package tual.windows

import scalafx.Includes._
import scalafx.scene.Scene
import scalafx.stage.{Stage, StageStyle}
import scalafxml.core.{ExplicitDependencies, FXMLView}

// TODO : this import may be not mandatory
import scalafx.scene.input.KeyCode.A

class Classic {

  private val stage = new Stage(StageStyle.Decorated)

  def show() {
    //
    // TODO : get the name of the story
    //
    stage.title = "Tual - "++" ??? name of the story ??? "
    //
    // TODO : refine the stage parameters
    //
    stage.width = 300//900
    stage.height = 300//700
    //
    val resource = getClass.getResource("/fxml/classic.fxml")
    //
    // TODO : fill up the dependency resolver with true information
    //
    val deps = new ExplicitDependencies(Map(
      "title" -> "test 123"
    ))
    //
    val root = FXMLView(resource, deps)
    val scene = new Scene(root) {
      fill = tual.tools.Style.currentBgColor
      stylesheets = tual.tools.Style.currentStyle
    }
    //
    // TODO : keyboard handle, only for test for now
    scene.onKeyReleased = keyEvent => {
      keyEvent.code match {
        //
        // TODO : handling A to switch back to Slash, for test
        //
        case A =>
          //
          println("eady to go back")
          //
          Splash.show()
          //
          stage.close
          //
        //
        case _ => ()
      }
    }
    //
    //
    stage.scene = scene
    //
    stage.show()
    //
  }
}
