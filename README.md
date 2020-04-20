# Tual
storytelling app

## TODO list:

* check for the css
* find a way to save app config
* open a file selector to save a file
* really save a file
* integrate sqlite

## Notes

The  `windows` dir contains objects to handle the stages handling.

The `controllers` dir contains classes which can react to the user inputs.

Why separate both? because `windows` handles only at the window level,
and `controllers` at a UI level, and because @sfxml doesn't work in the
same file.
