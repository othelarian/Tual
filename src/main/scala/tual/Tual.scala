package tual

import scalafx.application.JFXApp

object Tual extends JFXApp {
  tual.tools.Prefs.checkPrefs

  //
  // TODO : check the parameters
  //

  windows.Splash.show

}