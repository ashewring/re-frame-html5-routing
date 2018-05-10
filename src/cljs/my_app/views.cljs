(ns my-app.views
  (:require [re-frame.core :as re-frame]
            [my-app.routes :as routes]
            [my-app.subs :as subs]
            [my-app.layouts :as layouts]
            [my-app.components :as c]))

;; home

(defn- home-page-content
  []
  [:span
    [c/main-headline]
    [c/lines-of-business]
    [c/industries]

    ;; pre-loading content
    [:img
     {:style {:display "none"},
      :src "assets/images/icon-external-link-hover.png"}]
    [:script {:src "assets/js/LAB.min.js"}]
    [:script
     "\n\t\t$LAB\n\t\t .script(\"assets/js/jquery-1.11.3.min.js\").wait()\n\t\t .script(\"assets/js/main.js\")\n\t\t .script(\"assets/js/vendor/smooth-scroll-11.0.2.min.js\").wait()\n\t\t .script(\"assets/js/smooth-scrolling.js\");\n\t"]])

(defn home-panel []
  (layouts/full-width-layout
    "S23M - Business Performance Optimisation"
    "S23M makes sense of the world's information from your unique point of view. We offer business performance optimisation services."
    "Business Performance Optimisation"
    [home-page-content]))

;; about

(defn about-panel []
  [:div "This is the About Page."
   [:div [:a {:href (routes/url-for :home)} "go to Home Page"]]])


;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))
