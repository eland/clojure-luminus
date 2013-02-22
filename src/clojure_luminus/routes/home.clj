(ns clojure-luminus.routes.home
  (:use compojure.core hiccup.element hiccup.form)
  (:require [clojure-luminus.views.layout :as layout]
            [clojure-luminus.util :as util]
  					[clojure-luminus.models.db :as db]))

(defn show-activities []
  (into [:ul.activities]
        (for [{:keys [activity_name activity_time duration]} (db/read-activities)]
          [:li
           [:p activity_time]
           [:p activity_name]
           [:p duration " minutes"]])))
  
(defn home-page [& [activity_name activity_time duration error]]
  (layout/common
    [:h1 "Activity Log"]
   	[:p "Track your activites"]
   	[:p error]
   
   	(show-activities)
   
   	[:hr]
   	(form-to [:post "/"]
      [:p "Activity:" (text-field "activity_name" activity_name)]
      [:p "Activity Time:" (text-field "activity_time" activity_time)]
      [:p "Activity duration:" (text-field "duration" duration)]
      (submit-button "submit"))))

(defn save-activity [activity_name activity_time duration]
  (cond
   (empty? activity_name)
   (home-page activity_name activity_time duration "Don't forget to name your activity!")
   
   (empty? activity_time)
   (home-page activity_name activity_time duration "When did you do this activity?")

   (empty? duration)
   (home-page activity_name activity_time duration "How long did you do the activity?")
   
   :else
   (do 
     (db/save-activity activity_name activity_time duration)
		 (home-page))))

(defn about-page []
  (layout/common
   "this is the story of clojure-luminus... work in progress"))

(defroutes home-routes
  (GET "/" [activity_name activity_time duration error] (home-page activity_name activity_time duration error))
  (POST "/" [activity_name activity_time duration] (save-activity activity_name activity_time duration)))
