# Tual
storytelling app

## TODO list

* find a way to save app config
* really save a file
* integrate sqlite
* make a working textarea, to validate the use case
* add a font (Berylium)

## Ideas

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

### TODO : menu

* Welcome
  * last record
  * last entry
  * last note
  * free text zone (setting)
* Entities
* Records
* Tags
* Notes
* Settings

### TODO : categories

WHAT: An entity must be included in a category, like places,
characters, object of value, etc. The categories can be define
by the user.

WHERE: on a vertical line, fix to the left border, all the
categories with only an icon.

DEFAULT CATEGORIES: characters, places, object

### TODO : tags

tags are tags, just a name, handy to group together a bunch
of entities from differents categories, but unified around a
common theme.

### TODO : dice

### TODO : welcome screen

### TODO : record

WHAT: every piece of the story, a group of texts.

### TODO : notes

WHAT: small piece of text, here to help

### TODO : settings

* with or without dice? (setting)
* HIDE last dice config (setting)
* list of categories

## Notes

The  `windows` dir contains objects to handle the stages handling.

The `controllers` dir contains classes which can react to the user inputs.

Why separate both? because `windows` handles only at the window level,
and `controllers` at a UI level, and because @sfxml doesn't work in the
same file.
