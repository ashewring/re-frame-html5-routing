;; Compositions of various components
(ns my-app.layouts
  (:require [my-app.components :as c]))

(defn full-width-layout
  [heading description content]
  (let [title (str "S23M - " heading)]
    [:div
      [:div#container
        [c/meta-tags title description]
        [c/header heading]
        content]
        [c/disclaimer]]))
