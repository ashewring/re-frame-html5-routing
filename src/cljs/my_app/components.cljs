(ns my-app.components
  (:require [re-frame.core :as re-frame]
            [my-app.routes :as routes]
            [my-app.subs :as subs]
            [my-app.meta-tags :as meta-tags]
            [my-app.pages :as pages]
            [goog.i18n.DateTimeFormat :as dtf]
            [clojure.string :as s]
            ))

(defn- image
  [name]
  (str "/assets/images/" name))

(defn- current-year [] (.format (goog.i18n.DateTimeFormat. "yyyy") (js/Date.)))

(defn- copyright [] (str "Copyright " (current-year) " by S23M Limited"))

(defn meta-tags
  [title description]
  (js/console.log "meta-tags")
  [meta-tags/meta-tags {:title title :description description} {:id "copyright" :name "copyright" :content (copyright)}])

(defn- small-button
  [id]
  [:a.smallbutton
   {:href
     (routes/url-for id)}
     (pages/button-title id)])

(defn- buttons
  []
  (js/console.log "buttons")
  [:div.buttonholder
   [:span.buttons ;; TODO: proper event handling based on current page
    [:a.smallbutton.disabled
     ;;{:on-click "return false", :href "#"}
     "Home"]
    (small-button :about)
    [:a#news-button.smallbutton.news
      {:href (routes/url-for :news)}
      (pages/button-title :news)]
    (small-button :contact-us)]])

(defn header
  [heading]
  (js/console.log "header")
  [:div.header
   [:div.headerleft
    [:a
     {:href (routes/url-for :life)}
     [:img.s23m-logo
      {:title (pages/page-header :life),
       :alt (pages/page-header :life),
       :src (image "s23m-logo.png")}]]]
   [:div.headerright [:h1 heading]]
   (buttons)])

(defn main-headline
  []
  (js/console.log "main-headline")
  [:div.headline-container
    [:h2.headline
      "S23M makes sense of the world's information"
      [:br]
      "from your unique point of view"]])

(defn lines-of-business
  []
  (js/console.log "lines-of-business")
  [:div.section
   [:ul.responsive-list
    [:li.innovation-new-product-development
     [:div
      [:a.line-of-business
       {:href "innovation-new-product-development.html"}
       [:img.rounded {:src (image "value-cycle-design.jpg")}]
       [:h3 "Innovation & New Product Development"]]
      [:p
       "Helping you to innovate and make significantly better decisions"]]]
    [:li.operational-excellence
     [:div
      [:a.line-of-business
       {:href "operational-excellence.html"}
       [:img.rounded
        {:src (image "collaboration-whiteboard.jpg")}]
       [:h3 "Operational Excellence"]]
     [:p
      "Producing transformative improvements by reducing complexity and catalysing cultural transformation"]]]
    [:li.enterprise-saas
     [:div
      [:a.line-of-business
       {:href "enterprise-saas.html"}
       [:img.rounded {:src (image "saas.jpg")}]
       [:h3 "Enterprise Software as a Service"]]
      [:p
       "Enabling people and software systems to interact in the simplest possible way"]]]]])

(defn- name-to-filename
  [name]
  (s/replace (s/lower-case name) #" " "-"))

(defn- industries-image
  [name]
  (js/console.log (str "industries-image: " (image "industries/") (name-to-filename name) ".jpg"))

  [:img.rounded
    {:src (str (image "industries/") (name-to-filename name) ".jpg")}])

(defn- industry
  [name href]
  [:a.industry
    (if (s/starts-with? href "http")
      {:href href :target "_blank"}
      {:href href})
    (industries-image name)
    [:div.link-footer name]])

(defn- industry-button
  [id]
  (let [href (routes/url-for id)
        name (pages/button-title id)]
    [:a.industry
      (if (s/starts-with? href "http")
        {:href href :target "_blank"}
        {:href href})
      (industries-image name)
      (js/console.log (str "industry-button - href: '" href "', name: '" name "'"))
      [:div.link-footer name]]))

;; TODO: make this a def (static content)
(defn industries
  []
  (js/console.log "industries")
  [:div.section
    [:div.headline-container
      [:h2.headline "Industries"]]
    [:div.flowing-list-wrapper
      (industry-button :agriculture)
      (industry-button :healthcare)
      (industry-button :construction)
      (industry-button :logistics)
      (industry-button :industrial-automation)
      (industry-button :professional-services)
      (industry-button :government)
      (industry-button :ciic)
      ]])

(defn call-to-action
  [text]
  [:div.call-to-action-wrapper
    [:a.call-to-action-button
      {:href (routes/url-for :contact-us)}
      text]])

(defn footer
  []
  [:span
    [:div.footer-separator]
    [:div.colmask.footer
     [:div.colmid
      [:div.colright
       [:div.col1wrap
        [:div.col1pad
         [:div.col1
          [:table.links
            [:tbody
              [:tr
                [:td.left (small-button :case-studies)]
                [:td.center (small-button :life)]
                [:td.right (small-button :methodology)]]]]
              ]]]
       [:div.col2.sidebar-left
        [:span.left
         [:a
          {:title "Scroll to the top of this page", :href "#"}
          "Top ↑"]]
          ]
       [:div.col3.sidebar-right
        [:span.right (str "© 2002 - " (current-year) " ") [:span.s23m "S23M"]]
        ]]]]])

(defn disclaimer
  []
  [:div.disclaimer [:a {:href "disclaimer.html"} "Disclaimer"]])
