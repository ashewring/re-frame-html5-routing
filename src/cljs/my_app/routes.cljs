;; authored by J. PABLO FERNÁNDEZ - https://pupeno.com/2015/08/26/no-hashes-bidirectional-routing-in-re-frame-with-bidi-and-pushy/

(ns my-app.routes
  (:require [bidi.bidi :as bidi]
            [pushy.core :as pushy]
            [re-frame.core :as re-frame]
            [my-app.events :as events]
            [clojure.string :as s]))

(def routes ["/" {""      :home
                  "about" :about
                  ;; "about/" :about
                  ;; "about/index.html" :about
                  }])

(defn- remove-last-n [str n]
  (subs str 0 (- (count str) n)))

(defn- simplify [url]
  ;; if url ends with / or with /index.html, drop the suffix
  (cond
    (and (s/ends-with? url "/") (< (count url) 1)) (remove-last-n url 1)
    (s/ends-with? url "/index.html") (remove-last-n url 11)
    :else url))

(defn parse-url [url]
  (let [simplified (simplify url)]
    (js/console.log simplified)
    (bidi/match-route routes simplified)))

(defn- dispatch-route [matched-route]
  (js/console.log "dispatch-route")
  (let [panel-name (keyword (str (name (:handler matched-route)) "-panel"))]
    (re-frame/dispatch [::events/set-active-panel panel-name])))

(defn app-routes []
  (js/console.log "dispatch-route")
  (pushy/start! (pushy/pushy dispatch-route parse-url)))

(def url-for (partial bidi/path-for routes))
