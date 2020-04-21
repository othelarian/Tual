package tual.controllers

import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent

@sfxml
class SplashController {

  //
  // TODO : limit previously opened stories title to 37 chars
  //

  def newStory(event: ActionEvent) {
    //
    // TODO : create a new story
    //
    println("new")
    //
  }

  def openStory(event: ActionEvent) {
    //
    // TODO : open the file selector
    //
    // TODO : handle opening the story
    //
    println("open story")
    //
  }
}
