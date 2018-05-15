(ns my-app.views
  (:require [re-frame.core :as re-frame]
            [my-app.routes :as routes]
            [my-app.subs :as subs]
            [my-app.layouts :as layouts]
            [my-app.components :as c]))

;; home

(defn home-panel
  []
  (layouts/full-width-layout
    "Business Performance Optimisation"
    "S23M makes sense of the world's information from your unique point of view. We offer business performance optimisation services."
    [:span
      [:span
        [c/main-headline]
        [c/lines-of-business]
        [c/industries]
        [c/call-to-action "Contact us about your business challenges"]
        [c/footer :case-studies :life :methodology]]

      ;; pre-loading content
      [:img
       {:style {:display "none"},
        :src "assets/images/icon-external-link-hover.png"}]
      [:script {:src "assets/js/LAB.min.js"}]
      [:script
       "\n\t\t$LAB\n\t\t .script(\"assets/js/jquery-1.11.3.min.js\").wait()\n\t\t .script(\"assets/js/main.js\")\n\t\t .script(\"assets/js/vendor/smooth-scroll-11.0.2.min.js\").wait()\n\t\t .script(\"assets/js/smooth-scrolling.js\");\n\t"]]))

;; about

;; [:div "This is the About Page."
;;  [:div [:a {:href (routes/url-for :home)} "go to Home Page"]]])

(defn about-panel
  []
  (layouts/full-width-layout
    "About Us"
    "S23M is built around a powerful methodology for gaining a deep understanding of your business and its future potential."
    [:span
      "About"
      [:span [c/footer :case-studies :life :methodology]]]))

;; life

(defn life-panel
  []
  (layouts/full-width-layout
    "Collaboration for Life"
    "TODO"
    [:span
      "Collaboration for Life"
      [c/footer :case-studies :life :methodology]]))

;; methodology

(defn methodology-panel
  []
  (layouts/full-width-layout
    "Methodology"
    "TODO"
    [:span
      "Methodology"
      [c/footer :case-studies :life :methodology]]))

;; industrial-automation
(defn industrial-automation-panel
  []
  (layouts/full-width-layout
    "industrial-automation"
    "TODO"
    [:span
      "industrial-automation"
      [c/footer :case-studies :life :methodology]]))

;; 404

(defn not-found-panel
  []
  (layouts/full-width-layout
    "Page not found"
    "Page not found"
    [:span "Not found"]))

;; main

;; list of handlers corresponding to top-level-pages
(def ^:private top-level-pages
  #{:home :not-found})

(defn- assets-path [handler-name]
  (if (contains? top-level-pages handler-name)
    "assets"
    "../assets"))

(defn- panels [panel-name]
  (js/console.log (str "panels '" panel-name "'"))
  (let [assets-path (assets-path panel-name)]
    (case panel-name
      :home [home-panel]
      :about [about-panel]
      :life [life-panel]
      :methodology [methodology-panel]
      :industrial-automation [industrial-automation-panel]
      [not-found-panel])))

(defn show-panel [panel-name]
  (js/console.log (str "show-panel '" panel-name "'"))
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    (js/console.log "main-panel")
    [show-panel @active-panel]))
