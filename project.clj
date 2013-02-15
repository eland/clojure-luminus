(defproject clojure-luminus "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [lib-noir "0.3.7"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.2"]
                 [ring-server "0.2.7"]                 
                 [com.taoensso/timbre "1.5.1"]
                 [com.taoensso/tower "1.2.0"]
                 [markdown-clj "0.9.19"]]  
  :plugins [[lein-ring "0.8.2"]]
  :ring {:handler clojure-luminus.handler/war-handler
         :init    clojure-luminus.handler/init
         :destroy clojure-luminus.handler/destroy}  
  :profiles
  {:production {:ring {:open-browser? false 
                       :stacktraces?  false 
                       :auto-reload?  false}}
   :dev {:dependencies [[ring-mock "0.1.3"]
                        [ring/ring-devel "1.1.8"]]}}
  :min-lein-version "2.0.0")