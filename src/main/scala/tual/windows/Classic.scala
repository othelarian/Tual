package tual.windows

import scalafx.scene.Scene
import scalafx.scene.layout.VBox
import scalafx.scene.text.Text
import scalafx.stage.{Stage, StageStyle}
import scalafxml.core.{ExplicitDependencies, FXMLView}

object Classic {

  private val stage = new Stage(StageStyle.Decorated)

  private val layout = new VBox {
    children = new Text {
      text = "Classic..."
    }
  }
  
  def show() {
    //
    stage.title = "test"
    //
    stage.width = 300//900
    stage.height = 300//700
    //
    stage.scene = new Scene(layout)
    //
    stage.show()
    //
  }
}
