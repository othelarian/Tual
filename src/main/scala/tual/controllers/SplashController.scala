package tual.controllers

import scalafx.event.ActionEvent
import scalafx.scene.control.Button
import scalafx.scene.layout.{HBox, VBox}
import scalafx.scene.text.Text
import scalafxml.core.macros.sfxml

import tual.tools.{PrefsOk, PrefsNo, OpenFromSplash}

trait SplashControlInterface {
  def activeSelector
  def activeWaitor
}

@sfxml
class SplashController(
  leftSide: VBox,
  selector: HBox,
  waitor: VBox
) extends SplashControlInterface {

  leftSide.children = tual.tools.Prefs.getPrefs match {
    case prefs: PrefsOk => {
      if (prefs.list.isEmpty)
        Seq(new Text("No past story"), new Text("available"))
      else {
        val stories = prefs.list.map { story =>
          //
          // TODO : update the story with the true type that Prefs return
          //
          new Button() {
            text = story
            styleClass = Seq("splash_story_title")
            onAction = _ => tual.tools.Story.openStory(OpenFromSplash(Some(story)))
          }
        }
        stories.prepended(new Text("Past stories:"))
      }
    }
    case b: PrefsNo => {
      Seq(
        new Text("Preferences"),
        new Text("not available"),
      )
    }
  }

  def activeSelector = switch(true)
  def activeWaitor = switch(false)

  private def switch(select: Boolean) {
    selector.visible = select
    waitor.visible = !select
  }

  def newStory(event: ActionEvent) =
    tual.tools.Story.newStory(OpenFromSplash())

  def openStory(event: ActionEvent) =
    tual.tools.Story.openStory(OpenFromSplash())
}
