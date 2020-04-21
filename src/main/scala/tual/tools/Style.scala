package tual.tools

import scalafx.scene.paint.Color

object StyleType extends Enumeration {
  class StyleValue(val i: Int, val name: String, val color: Color, val uri: String)
  extends Val(i: Int, name: String)

  val LightStyle = new StyleValue(0, "Light", Color.LightGray, "/styles/light.css")
  val DarkStyle = new StyleValue(1, "Dark", Color.DarkGray, "/styles/dark.css")
}

object Style {
  private var currStyle = StyleType.LightStyle

  def setStyle(newStyle: StyleType.StyleValue) { currStyle = newStyle }

  def currentBgColor(): Color = currStyle.color

  def currentStyle(): List[String] =
    List(getClass.getResource(currStyle.uri).toExternalForm)
}
