(ns my-app.layouts
  (:require [my-app.components :as c]))

(defn full-width-layout
  [title description heading content]
  [:div
    [:div#container
      [c/meta-tags title description]
      [c/header heading]
      content]
      ;; TODO: add footer, disclaimer
      [c/disclaimer]]

  )
