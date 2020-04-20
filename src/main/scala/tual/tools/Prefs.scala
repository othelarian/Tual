package tual.tools

object Prefs {
  //
  // TODO : using java.utils.Prefs
  //

  private var noPrefs = false

  def checkPrefs(): Either[String, Int] = {
    //
    // TODO : check if there is already a prefs file
    //
    // TODO : if there is a prefs file, try to read it
    //
    // TODO : if there is no prefs file, try to write it
    //
    // TODO : if something wrong happen, Left with why
    //
    // TODO : if it's all good, right with number of previously opened stories
    //
    Right(0)
    //Left("Test ???")
    //
  }

  def goWithoutPrefs() { noPrefs = true }
}
