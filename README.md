# Tual
storytelling app

## TODO list

* find a way to save app config
* open a file selector to save a file
* really save a file
* integrate sqlite
* make a working textarea, to validate the use case

## Ideas

### TODO story class

Each story must be handle separately, and for a story, it's mandatory to
regroup the opened windows and the controllers.

### TODO main menu

* create a new story -> alert to select two options:
  * closing current story and replace it with the new one
  * open the new one in a new window
* open a new story -> alert to select two options:
  * closing current story and replace it with the new one
  * open the new one in a new window, and keep the old one open
* open a new window of the current story
* close the current window
* close the current story
* quit the app

## Notes

The  `windows` dir contains objects to handle the stages handling.

The `controllers` dir contains classes which can react to the user inputs.

Why separate both? because `windows` handles only at the window level,
and `controllers` at a UI level, and because @sfxml doesn't work in the
same file.
