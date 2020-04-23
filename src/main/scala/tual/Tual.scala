package tual

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

object Tual extends JFXApp {
  tual.tools.Prefs.checkPrefs

  //
  // TODO : check the parameters
  //

  windows.Splash.show(new PrimaryStage())

}