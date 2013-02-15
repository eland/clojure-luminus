(ns clojure-luminus.routes.home
  (:use compojure.core hiccup.element)
  (:require [clojure-luminus.views.layout :as layout]
            [clojure-luminus.util :as util]))

(defn home-page []
  (layout/common
    (util/md->html "/md/docs.md")))

(defn about-page []
  (layout/common
   "this is the story of clojure-luminus... work in progress"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page)))
