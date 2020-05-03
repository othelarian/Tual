package tual

import scalafx.application.JFXApp
// TODO : check if this import is still mandatory
//import scalafx.application.JFXApp.PrimaryStage

object Tual extends JFXApp {
  tual.tools.Prefs.checkPrefs

  //
  // TODO : check the parameters
  //

  windows.Splash.show

}