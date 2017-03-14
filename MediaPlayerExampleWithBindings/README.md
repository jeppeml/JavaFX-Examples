# MediaPlayerExampleWithBindings
Example of using the mediaplayer to bind to a text property

If you use the MediaPlayer class from JavaFX, and want to bind the time elapsed for your  media, 
you can use the currentTimeProperty() method to fetch a JavaFX property for this. This is however
a ReadOnlyProperty\<Duration\> and therefore it is not easy to bind it to the text property of i.e. 
a label.

This example shows you how to bind using a special StringBinding class
