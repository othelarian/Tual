package tual

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

object Tual extends JFXApp {
  //
  // TODO : find a way to save app config
  //

  //
  // TODO : check the parameters
  //
  //println(parameters)

  // TODO : load prefs

  var stylesheet = List(getClass.getResource("/styles/default.css").toExternalForm)

  windows.Splash.show(new PrimaryStage())

  def open() {
    //
    // TODO : handle opening a story
    //
    //val win1 = new windows.Classic()
    //win1.show()
    //
    //val win2 = new windows.Classic()
    //win2.show()
    //
  }
}