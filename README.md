# clojure-luminus

This is a project I'm working on to both get a feel for clojure and using clojure as a web backend.
It'll be a simple activity logging application, such as for tracking when you run and for how long.
I'll then visualize this data with a JavaScript library or frontend.

Authentication/different users will come after basic functionality.

I'm programming this using LightTable, which looks like it has a lot of potential (especially for extensibility) --
I could see it becoming a more modern, more graphical Emacs. It's written almost entirely in ClojureScript.

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server
