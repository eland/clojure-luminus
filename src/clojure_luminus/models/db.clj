(ns clojure-luminus.models.db
  (:require [clojure.java.jdbc :as sql]))

(def db {:classname   "org.h2.Driver"
         :subprotocol "h2"
         :user        "sa"
         :password    ""
         :subname     "site"})

(defn create-activity-table []
  (sql/with-connection
   	db
    (sql/create-table
     :activity_log
     [:id "INTEGER PRIMARY KEY AUTO_INCREMENT"]
     [:timestamp :timestamp]
     [:activity_name "varchar(30)"]
     [:activity_time "datetime"])))

(defn read-activity []
  (sql/with-connection
   db
   (sql/with-query-results res
    ["SELECT * FROM activity_log ORDER BY activity_time DESC"]
      (doall res))))

(defn save-activity [activity_name activity_time]
  (sql/with-connection
    db
    (sql/insert-values
     	:activity_log
      [:activity_name :activity_time :timestamp]
      [activity_name activity_time (new java.util.Date)])))